public class day52 {
    public boolean judgeSquareSum(int c) {
        int l = 0, r = (int)Math.sqrt(c);
        
        while(l <= r){
            if(((l*l) + (r*r)) < c) l++;
            else if(((l*l) + (r*r)) > c) r--;
            else return true;
        }
        return false;
    }
}
