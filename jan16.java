public class jan16 {
    public int maxDistToClosest(int[] seats) {
        if(seats.length == 2) return 1;
        int distance = 0, fpos = -1 , lpos = -1 , temp = 0;
        boolean flag = false;
        
        for(int i = 0; i < seats.length; i++){
            if(seats[i] == 0) temp++;
            else{
                if(!flag){
                    flag = true;
                    fpos = i;
                }
                lpos = i;
                distance = Math.max(distance , temp);
                temp = 0;
            }
        }
        distance = Math.max((distance + 1) / 2 , Math.max(fpos , seats.length - 1 - lpos));
        
        return distance;
    }
}
