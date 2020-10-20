package lozm.chatting;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ClientExample extends Application {

    SocketChannel socketChannel;
    TextArea textArea;
    TextField textField;
    Button btnConnect, btnSend;

    public static void main(String[] args) {
        launch(args);
    }

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
        try {
            displayText("[연결 끊음]");
            btnConnect.setText("start");
            btnConnect.setDisable(true);

            if(socketChannel != null && socketChannel.isOpen()) socketChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void receive() {
        //데이터 받기 코드
        while (true) {
            try {
                ByteBuffer byteBuffer = ByteBuffer.allocate(100);

                //서버가 비정상적으로 종료했을경우 IOException 발생
                int readByteCount = socketChannel.read(byteBuffer);
                if(readByteCount == -1) throw new IOException();

                byteBuffer.flip();
                Charset charset = Charset.forName("UTF-8");
                String data = charset.decode(byteBuffer).toString();

                Platform.runLater(() -> displayText("[받기 완료]" + data));
            } catch (Exception e) {
                e.printStackTrace();
                Platform.runLater(() -> displayText("[서버 통신 안 됨]"));
                stopClient();
                break;
            }
        }
    }

    void send(String data) {
        //데이터 전송 코드
        Thread thread = new Thread() {
          @Override
          public void run() {
              try {
                  Charset charset = Charset.forName("UTF-8");
                  ByteBuffer byteBuffer = charset.encode(data);
                  socketChannel.write(byteBuffer);
                  Platform.runLater(() -> displayText("[보내기 완료]"));
              } catch (Exception e) {
                  e.printStackTrace();
                  Platform.runLater(() -> displayText("[서버 통신 안 됨]"));
                  stopClient();
              }
          }
        };

        thread.start();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        root.setPrefSize(500, 300);

        textArea = new TextArea();
        textArea.setEditable(false);
        BorderPane.setMargin(textArea, new Insets(0, 0, 2, 0));
        root.setCenter(textArea);

        BorderPane bottom = new BorderPane();
        textField = new TextField();
        textField.setPrefSize(60, 30);
        BorderPane.setMargin(textArea, new Insets(0, 1, 1, 1));

        btnConnect = new Button();
        btnConnect.setPrefSize(60, 30);
        btnConnect.setOnAction(e -> {
            if(btnConnect.getText().equals("start")) startClient();
            else if(btnConnect.getText().equals("stop")) stopClient();
        });

        btnSend = new Button("send");
        btnSend.setPrefSize(60, 30);
        btnSend.setDisable(true);
        btnSend.setOnAction(e -> send(textArea.getText()));

        bottom.setCenter(textArea);
        bottom.setLeft(btnConnect);
        bottom.setRight(btnSend);
        root.setBottom(bottom);

        Scene scene = new Scene(root);
//        scene.getStylesheets().add(getClass().getResource("app.css").toString());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Client");
        primaryStage.setOnCloseRequest(event -> stopClient());
        primaryStage.show();
    }

    void displayText(String text) {
        textArea.appendText(text + "\n");
    }

}