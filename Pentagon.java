import java.util.List;

import collision.CollidableEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Pentagon extends CollidableEntity{

    
    int screenX;
    int screenY;
    int moveSpeed;
    String direction = "right";
    
    KeyHandler keyH;
    
    public Pentagon(List<Integer[]> points) {
        super(points, RenderScreen.SCALE);
        setInitialValues();
    }

    private void setInitialValues() {
        this.screenX = 750;
        this.screenY = 250;
        this.moveSpeed = 10;
    }

    @Override
    public void drawPolygonCollider(GraphicsContext gc, int screenX, int screenY) {

    }

    public void update() {

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

