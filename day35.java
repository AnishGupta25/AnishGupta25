public class day35 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) return image;
        boolean[][] visited = new boolean[image.length][image[0].length];
        int prev = image[sr][sc];
        flood(image , sr , sc , newColor , prev , visited);
        return image;
    }
    public void flood(int[][] image , int sr , int sc , int newColor , int prev , boolean[][] visited){
        if(sr == image.length || sc == image[0].length || sr < 0 || sc < 0 ) return;
        if(image[sr][sc] != prev) return;
        if(visited[sr][sc]) return;
        if(!visited[sr][sc]){
            visited[sr][sc] = true;
            image[sr][sc] = newColor;
        }
        
        flood(image , sr + 1 , sc , newColor , prev , visited);
        flood(image , sr , sc + 1 , newColor , prev , visited);
        flood(image , sr , sc - 1 , newColor , prev , visited);
        flood(image , sr - 1 , sc , newColor , prev , visited);
    }
}
