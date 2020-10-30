package lozm.chatting2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
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

    void stopServer() {
        try {
            Iterator<Client> iterator = connections.iterator();
            while(iterator.hasNext()) {
                Client client = iterator.next();
                client.socketChannel.close();
                iterator.remove();
            }

            if(serverSocketChannel != null && serverSocketChannel.isOpen()) serverSocketChannel.close();

            if(selector != null && selector.isOpen()) selector.close();

            Platform.runLater(() -> {
                displayText("[서버 종료]");
                btnStartStop.setText("start");
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    };

    void accept(SelectionKey selectionKey) {
        //연결 수락 코드
        try {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();

            String message = "[연결 수락:" + socketChannel.getRemoteAddress() + ": " + Thread.currentThread().getName() + "]";
            Platform.runLater(() -> displayText(message));

            Client client = new Client(socketChannel);
            connections.add(client);

            Platform.runLater(() -> displayText("[연결 개수: " + connections.size() + "]"));
        } catch (Exception e) {
            if(serverSocketChannel.isOpen()) stopServer();
        }
    };

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    //데이터 통신 코드
    class Client {

        SocketChannel socketChannel;
        String sendData; //클라이언트로 보낼 데이터를 저장하는 필드


        Client(SocketChannel socketChannel) throws IOException {
            this.socketChannel = socketChannel;
            this.socketChannel.configureBlocking(false);

            //읽기 작업 유형으로 Selector 에 등록시킴
            SelectionKey selectionKey = this.socketChannel.register(selector, SelectionKey.OP_READ);

            //SelectionKey 에 자기 자신을 첨부 객체로 저장
            selectionKey.attach(this);
        }

        void receive(SelectionKey selectionKey) {
            //데이터 받기 코드
        }

        void send(SelectionKey selectionKey) {
            //데이터 전송 코드
        }
    }

}