package lozm;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.nio.file.*;
import java.util.List;

public class WatchServiceExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    TextArea textArea;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        root.setPrefSize(500, 300);

        textArea = new TextArea();
        textArea.setEditable(false);
        root.setCenter(textArea);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("WatchServiceImpl");
        primaryStage.show();

        WatchServiceThread watchServiceThread = new WatchServiceThread();
        watchServiceThread.start();
    }

    class WatchServiceThread extends Thread {

        @Override
        public void run() {
            try {
                java.nio.file.WatchService watchService = FileSystems.getDefault().newWatchService();
                Path directory = Paths.get("/Users/junlee/git/lozm");

                directory.register(
                        watchService,
                        StandardWatchEventKinds.ENTRY_CREATE,
                        StandardWatchEventKinds.ENTRY_DELETE,
                        StandardWatchEventKinds.ENTRY_MODIFY
                );

                while(true) {
                    WatchKey watchKey = watchService.take();//블로킹(WatchKey 가 큐에 들어올때까지)
                    List<WatchEvent<?>> list = watchKey.pollEvents();

                    for (WatchEvent watchEvent : list) {
                        //이벤트 종류 얻기
                        WatchEvent.Kind kind = watchEvent.kind();

                        //감지된 Path 얻기
                        Path path = (Path) watchEvent.context();

                        if(kind == StandardWatchEventKinds.ENTRY_CREATE) {
                            Platform.runLater(() -> textArea.appendText("파일 생성됨 -> " + path.getFileName() + "\n"));
                        } else if(kind == StandardWatchEventKinds.ENTRY_DELETE) {
                            Platform.runLater(() -> textArea.appendText("파일 삭제됨 -> " + path.getFileName() + "\n"));
                        } else if(kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                            Platform.runLater(() -> textArea.appendText("파일 수정됨 -> " + path.getFileName() + "\n"));
                        } else if(kind == StandardWatchEventKinds.OVERFLOW) {

                        }

                        boolean valid = watchKey.reset();
                        if(!valid) break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}