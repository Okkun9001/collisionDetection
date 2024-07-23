package physics;

public abstract class Vector {
    
    
    public static double[] normalize(double[] axis) {
        double[] normalized = new double[axis.length];
        for(int i = 0; i < axis.length; i++){
            if(axis[i] != 0){
                double magnitude = magnitude(axis);
                normalized[i] = (axis[i]/magnitude);
            }
        }
        return normalized;
    }

    public static double magnitude(double[] axis) {
        
        double sum = 0;
        for(int i = 0; i < axis.length; i++){
            sum += axis[i]*axis[i];
        }
        return Math.sqrt(sum);
    }

    public static double[] getNormal(double[] p1, double[] p2) {
        
        double[] edge = {p2[0] - p1[0], p2[1] - p1[1]};
        double[] normal = {edge[1], -edge[0]};
        return normal;
    }

    public static double dotProduct(double[] point, double[] normalizedAxis) {
        
        double sum = 0;
        for(int i = 0; i < point.length; i++){
            sum += point[i]*normalizedAxis[i];
        }

        return sum;
    }

}
