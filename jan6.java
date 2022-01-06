public class jan6 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] stop = new int[1001];
        
        for(int[] trip : trips){
            stop[trip[1]] += trip[0];
            stop[trip[2]] -= trip[0];
        }
        
        int pass = 0;
        
        for(int val : stop){
            pass += val;
            if(pass > capacity) return false;
        }
        return true;
    }
}
