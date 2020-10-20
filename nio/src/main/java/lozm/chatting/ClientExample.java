package lozm.chatting;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ClientExample extends Application {

    SocketChannel socketChannel;

    void startClient() {
        //연결 시작 코드
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    //소켓 생성 및 연결 요청
                    socketChannel = SocketChannel.open();
                    socketChannel.configureBlocking(true);
                    socketChannel.connect(new InetSocketAddress("localhost", 5001));

                    Platform.runLater(() -> {
                        try {
                            displayText("[연결 완료: " + socketChannel.getRemoteAddress() + "]");
                            btnConnect.setText("stop");
                            btnConnect.setDisable(false);
                        } catch (Exception e) {
                            e.printStackTrace();
                            Platform.runLater(() -> displayText("[서버 통신 안 됨]"));
                            if(socketChannel.isOpen()) stopClient();
                            return;
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    Platform.runLater(() -> displayText("[서버 통신 안 됨]"));
                    if(socketChannel.isOpen()) stopClient();
                    return;
                }

                receive();
            }
        };

        thread.start();
    }

    void stopClient() {
        //연결 끊기 코드
    }

    void receive() {
        //데이터 받기 코드
    }

    void send() {
        //데이터 전송 코드
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

}