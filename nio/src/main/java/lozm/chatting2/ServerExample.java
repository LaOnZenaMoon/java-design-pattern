package lozm.chatting2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class ServerExample extends Application {

    Selector selector;
    ServerSocketChannel serverSocketChannel;
    List<Client> connections = new Vector<Client>();

    void startServer() {
        try {
            selector = Selector.open();

            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(5001));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception e) {
            if(serverSocketChannel.isOpen()) stopServer();
            return;
        }

        Thread thread = new Thread() {
            @Override
            public void run() {
                while(true) {
                    try {
                        //작업 처리 준비가 된 채널이 있을 때까지 대기
                        int keyCount = selector.select();
                        if(keyCount == 0) continue;

                        //작업 처리 준비가 된 키를 얻고 Set 컬렉션으로 리턴
                        Set<SelectionKey> selectedKeys = selector.selectedKeys();
                        Iterator<SelectionKey> iterator = selectedKeys.iterator();
                        while(iterator.hasNext()) {
                            SelectionKey selectionKey = iterator.next();

                            if(selectionKey.isAcceptable()) {
                                //연결 수락 작업일 경우
                                accept(selectionKey);
                            } else if (selectionKey.isReadable()) {
                                //읽기 작업일 경우
                                Client client = (Client) selectionKey.attachment();
                                client.receive(selectionKey);
                            } else if(selectionKey.isWritable()) {
                                //쓰기 작업일 경우
                                Client client = (Client) selectionKey.attachment();
                                client.send(selectionKey);
                            }

                            //선택된 키셋에서 처리 완료된 SelectionKey 를 제거
                            iterator.remove();
                        }
                    } catch (Exception e) {
                        if(serverSocketChannel.isOpen()) stopServer();
                        break;
                    }
                }
            }

            Platform.runLater(() -> {
                displayText("[서버 시작]");
                btnStartStop.setText("stop");
            });
        };

        thread.start();
    };

    void stopServer() {};

    void accept(SelectionKey selectionKey) {
        //연결 수락 코드
    };

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    class Client {
        //데이터 통신 코드
    }


}