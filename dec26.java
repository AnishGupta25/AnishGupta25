import java.util.*;
public class dec26 {
    class Point {
        int x;
        int y;
        double dist;

        Point(int x, int y, double dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        
        PriorityQueue<Point> pq = new PriorityQueue<>((a , b) -> Double.compare(a.dist , b.dist));
        
        for(int i = 0; i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            double dist = Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            Point point = new Point(x, y, dist);
            pq.add(point);
        }
        
        for(int i = 0; i < k; i++){
            Point point = pq.poll();
            res[i][0] = point.x;
            res[i][1] = point.y;
        }
        return res;
    }
}
