public class day64 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int time = releaseTimes[0];
        char ch = keysPressed.charAt(0);
        for(int i = 1; i < releaseTimes.length; i++){
            int val = releaseTimes[i] - releaseTimes[i - 1];
            if(val > time){
                time = val;
                ch = keysPressed.charAt(i);
            }
            else if(val == time){
                if(keysPressed.charAt(i) > ch){
                    ch = keysPressed.charAt(i);
                }
            }
        }
        return ch;
    }
}
