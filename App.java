import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primStage) throws Exception {
        


        RenderScreen root = new RenderScreen();
        root.startLoop();
        Scene scene = new Scene(root);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, root.keyH);
        scene.addEventHandler(KeyEvent.KEY_RELEASED, root.keyH);
        primStage.setScene(scene);
        primStage.show();
    }
}
