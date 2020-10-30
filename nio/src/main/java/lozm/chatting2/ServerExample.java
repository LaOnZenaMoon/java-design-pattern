package lozm.chatting2;

import javafx.application.Application;
import javafx.stage.Stage;

import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.List;
import java.util.Vector;

public class ServerExample extends Application {

    Selector selector;
    ServerSocketChannel serverSocketChannel;
    List<Client> connections = new Vector<Client>();

    void startServer() {};

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