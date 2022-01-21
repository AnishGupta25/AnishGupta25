public class jan21 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int station = 0, fuel = 0;
        int t1 = 0, t2 = 0;
        
        for(int i = 0; i < gas.length; i++){
            t1 += gas[i];
            t2 += cost[i];
        }
        if(t2 > t1) return -1;
        
        for(int i = 0; i < gas.length; i++){
            fuel += gas[i] - cost[i];
            if(fuel < 0){
                fuel = 0;
                station = i+1;
            }
        }
        return station;
    }
}
