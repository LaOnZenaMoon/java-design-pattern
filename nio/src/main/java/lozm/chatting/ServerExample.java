package lozm.chatting;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ServerExample extends Application {

    ExecutorService executorService;
    ServerSocketChannel serverSocketChannel;
    List<Client> connections = new Vector<Client>();

    private void startServer() {
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(true);
            serverSocketChannel.bind(new InetSocketAddress(5001));
        } catch (Exception e) {
            e.printStackTrace();
            if(serverSocketChannel.isOpen()) stopServer();
        }

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    displayText("[서버 시작]");
                    btnStartStop.setText("stop");
                });

                while(true) {
                    try {
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        String message = "[연결 수락: " + socketChannel.getRemoteAddress() + ": " + Thread.currentThread().getName() + "]";
                        Platform.runLater(() -> displayText(message));

                        Client client = new Client(socketChannel);
                        connections.add(client);
                        Platform.runLater(() -> displayText("[연결 개수: " + connections.size() + "]"));
                    } catch (Exception e) {
                        e.printStackTrace();
                        if(serverSocketChannel.isOpen()) stopServer();
                        break;
                    }
                }
            }
        };

        executorService.submit(runnable);
    }

    private void stopServer() {
        try {
            Iterator<Client> iterator = connections.iterator();
            while (iterator.hasNext()) {
                Client client = iterator.next();
                client.socketChannel.close();
                iterator.remove();
            }

            if(serverSocketChannel != null && serverSocketChannel.isOpen()) serverSocketChannel.close();

            if(executorService != null && !executorService.isShutdown()) executorService.shutdown();

            Platform.runLater(() -> {
                displayText("[서버 멈춤]");
                btnStartStop.setText("start");
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class Client {

        SocketChannel socketChannel;

        Client(SocketChannel socketChannel) {
            this.socketChannel = socketChannel;
            receive();
        }

        void receive() {
            //데이터 받기 코드
            Runnable runnable = () -> {
                while(true) {
                    try {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(100);

                        //클라이언트가 비정상 종료를 했을 경우 IOException 이 발생
                        int readByteCount = socketChannel.read(byteBuffer);
                        if(readByteCount == -1) throw new IOException();

                        String message = "[요청 처리: " + socketChannel.getRemoteAddress() + ": " + Thread.currentThread().getName() + "]";
                        Platform.runLater(() -> displayText(message));

                        byteBuffer.flip();
                        Charset charset = Charset.forName("UTF-8");
                        String data = charset.decode(byteBuffer).toString();

                        for (Client client : connections) {
                            client.send(data);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        try {
                            connections.remove(Client.this);
                            String message = "[클라이언트 통신 안 됨: " + socketChannel.getRemoteAddress() + ": " + Thread.currentThread().getName() + "]";
                            Platform.runLater(() -> displayText(message));
                            socketChannel.close();
                        } catch (Exception innerE) {
                            innerE.printStackTrace();
                            break;
                        }
                    }
                }
            };

            executorService.submit(runnable);
        }

        void send(String data) {
            //데이터 전송 코드
            Runnable runnable = () -> {
                try {
                    Charset charset = Charset.forName("UTF-8");
                    ByteBuffer byteBuffer = charset.encode(data);
                    socketChannel.write(byteBuffer);
                } catch (Exception e) {
                    e.printStackTrace();

                    try {
                        String message = "[클라이언트 통신 안 됨: " + socketChannel.getRemoteAddress() + ": " + Thread.currentThread().getName() + "]";
                        Platform.runLater(() -> displayText(message));
                        socketChannel.close();
                    } catch (Exception innerE) {
                        innerE.printStackTrace();
                    }
                }
            };

            executorService.submit(runnable);
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

}