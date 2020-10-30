package lozm.chatting2;

import javafx.application.Application;
import javafx.stage.Stage;

import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Vector;

public class ServerExample extends Application {

    Selector selector;
    ServerSocketChannel serverSocketChannel;
    List<Client> connections = new Vector<Client>();


    @Override
    public void start(Stage primaryStage) throws Exception {

    }

}