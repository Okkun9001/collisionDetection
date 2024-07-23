package collision;

import java.util.List;

public abstract class CollidableEntity implements Collidable{
    
    //Hitbox
    protected List<Integer[]> hitboxPoints;
    protected double[] xPoints, yPoints;
    protected boolean collision = false;

    public CollidableEntity(List<Integer[]> points, double scale) {
        this.hitboxPoints = points;
        this.xPoints = new double[hitboxPoints.size()];
        this.yPoints = new double[hitboxPoints.size()];
        for(int i = 0; i < hitboxPoints.size(); i++){
            hitboxPoints.get(i)[0] = (int)(hitboxPoints.get(i)[0]*scale);
            hitboxPoints.get(i)[1] = (int)(hitboxPoints.get(i)[1]*scale);
            xPoints[i] = hitboxPoints.get(i)[0]; 
            yPoints[i] = hitboxPoints.get(i)[1];
        }
    }
    
    public double[][] getVerteces(){

        double[][] verteces = new double[xPoints.length][2];
        for(int i = 0; i < hitboxPoints.size(); i++){
            verteces[i][0] = xPoints[i];
            verteces[i][1] = yPoints[i];
        }
        
        return verteces; 
    
    }
    
    public boolean isSolid() { return collision; }

    public int getWorldX() { return 0; }
    

}
