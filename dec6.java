public class dec6 {
    public int minCostToMoveChips(int[] position) {
        int even = 0 , odd = 0;
        
        for(int i : position){
            if(i % 2 == 0) even++;
            else odd++;
        }
        return Math.min(odd , even);
    }
}
