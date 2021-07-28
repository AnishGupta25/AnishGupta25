import java.util.ArrayList;

public class day26 {
    public int[] beautifulArray(int n) {
        ArrayList<Integer> beaArr = new ArrayList<>();
        beaArr.add(1);
        
        while(beaArr.size() < n){
            ArrayList<Integer> curr = new ArrayList<>();
            for(int i : beaArr){
                if(i*2 - 1 <= n) curr.add(i*2 - 1);
            }
            for(int i : beaArr){
                if(i*2 <= n) curr.add(i*2);
            }
            beaArr = curr;
        }
        
        int[] res = new int[beaArr.size()];
        for(int i = 0; i < beaArr.size(); i++){
            res[i] = beaArr.get(i);
        }
        return res;
    }
}
