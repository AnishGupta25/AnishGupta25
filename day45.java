public class day45 {
    public int largestAltitude(int[] gain) {
        if(gain.length == 0) return 0;
        
        int sum = 0;
        int maxAlti = -1000000;
        for(int i = 0; i < gain.length; i++){
            sum += gain[i];
            if(sum > maxAlti) maxAlti = sum;
            if(maxAlti < 0) maxAlti = 0;
        }
        return maxAlti;
    }
}
