package collision;

import javafx.scene.canvas.GraphicsContext;

public interface Collidable {

    public void drawPolygonCollider(GraphicsContext gc, int screenX, int screenY);

    public double[][] getVerteces();
    
    public boolean isSolid();

}
