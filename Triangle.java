import java.util.List;

import collision.CollidableEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends CollidableEntity{

    double screenX;
    double screenY;
    double moveSpeed;
    String direction = "right";

    KeyHandler keyH;

    public Triangle(List<Integer[]> points, KeyHandler keyH) {
        super(points, RenderScreen.SCALE);
        setInitialValues();
        this.keyH = keyH;
    }

    private void setInitialValues() {
        this.screenX = 50;
        this.screenY = 50;
        this.moveSpeed = 5;
    }

    @Override
    public void drawPolygonCollider(GraphicsContext gc, int screenX, int screenY) {

    }

    public void update() {

        if(keyH.isPressed("RIGHT")) {
            direction = "right";
            screenX += moveSpeed;
        } else if(keyH.isPressed("LEFT")) {
            direction = "left";
            screenX -= moveSpeed;
        } else if(keyH.isPressed("UP")) {
            direction = "up";
            screenY -= moveSpeed;
        } else if(keyH.isPressed("DOWN")) {
            direction = "down";
            screenY += moveSpeed;
        }

        for(int i = 0; i < hitboxPoints.size(); i++){
            xPoints[i] = hitboxPoints.get(i)[0] + screenX;
            yPoints[i] = hitboxPoints.get(i)[1] + screenY;
        }
    }
    
    public void draw(GraphicsContext gc) {
        gc.setStroke(Color.BLUE);
        gc.strokePolygon(xPoints, yPoints, hitboxPoints.size());
    }

}
