package collision;

import physics.Vector;

public abstract class CollisionDetector {

    public static boolean checkCollision(Collidable e1, Collidable e2){

        double[][] shape1 = e1.getVerteces();
        double[][] shape2 = e2.getVerteces();
        
        double[][] axis1 = getAxis(shape1);
        double[][] axis2 = getAxis(shape2);

        //Check for overlap on 1st shape's axis
        for(int i=0; i<axis1.length; i++){
            double[] axis = axis1[i];

            double[] proj1 = project(shape1, axis);
            double[] proj2 = project(shape2, axis);
            if(!overlap(proj1, proj2)){
                return false;
            }
        }
        //Check for overlap on 2nd shape's axis
        for(int i=0; i<axis2.length; i++){
            double[] axis = axis2[i];

            double[] proj1 = project(shape1, axis);
            double[] proj2 = project(shape2, axis);
            if(!overlap(proj1, proj2)){
                return false;
            }
        }

        //Everything overlaps so return true
        return true;
        
    }
    
    private static boolean overlap(double[] proj1, double[] proj2) {
        return !(proj1[1] < proj2[0] || proj2[1] < proj1[0]);
    }

    private static double[] project(double[][] hitboxPoints, double[] axis) {
        
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double[] normalizedAxis = Vector.normalize(axis);

        for(int i = 0; i < hitboxPoints.length; i++){
            double[] point = {hitboxPoints[i][0], hitboxPoints[i][1]};
            double projection = Vector.dotProduct(point, normalizedAxis);
            if(projection < min){
                min = projection;
            }
            if(projection > max){
                max = projection;
            }
        }
        return new double[]{min, max};
    }

    private static double[][] getAxis(double[][] verteces){
        double[][] axis = new double[verteces.length][2];
        for(int i = 0; i < verteces.length; i++){
            int j = (i+1)%verteces.length;

            double[] p1 = {verteces[i][0], verteces[i][1]};
            double[] p2 = {verteces[j][0], verteces[j][1]};
            double[] normal = Vector.getNormal(p1, p2);
            axis[i][0] = normal[0];
            axis[i][1] = normal[1];
        }
        return axis;
    }
    
}
