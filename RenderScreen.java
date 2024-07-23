import java.util.List;

import collision.CollisionDetector;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

public class RenderScreen extends Pane {

    private Canvas canvas;
    private GraphicsContext gc;
    public final static double SCALE = 7;

    public KeyHandler keyH = new KeyHandler();
    private Triangle triangle;
    private Pentagon pentagon;

    public RenderScreen() {
        this.setPrefSize(1200, 800);
        this.canvas = new Canvas(1200, 800);
        this.getChildren().add(canvas);
        this.gc = canvas.getGraphicsContext2D();
        this.setStyle("-fx-background-color: grey");
        initializeObjects();
    }

    private void initializeObjects() {
    
        List<Integer[]> points = List.of(new Integer[]{0, 0}, new Integer[]{28, 8}, new Integer[]{0, 16});
        this.triangle = new Triangle(points, keyH);

        List<Integer[]> points2 = List.of(new Integer[]{6, 0}, new Integer[]{0, 12}, new Integer[]{12, 20}, new Integer[]{24, 12}, new Integer[]{18, 0});
        this.pentagon = new Pentagon(points2);

    }

    public void startLoop(){
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                redraw();
            }
        }.start();
    }

    private void update() {
        triangle.update();
        pentagon.update();
        System.out.println(CollisionDetector.checkCollision(triangle, pentagon));
    }

    private void redraw() {
        gc.clearRect(0, 0, 1200, 800);
        draw(gc);
    }

    private void draw(GraphicsContext gc) {
        triangle.draw(gc);
        pentagon.draw(gc);
    }
}
