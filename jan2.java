public class jan2 {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0 , j = 0;
        
        while(j < typed.length()){
            if(i < name.length() && name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }
            else if(j > 0 && typed.charAt(j-1) == typed.charAt(j)) j++;
            else return false;
        }
        return i == name.length();
    }

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        for(int k = 0; k < updates.length; k++){
            arr[updates[k][0]] += updates[k][2];
            if((updates[k][1]+1) < length) arr[updates[k][1]+1] -= updates[k][2];
        }

        for(int i = 1; i < length; i++){
            arr[i] += arr[i-1];
        }
        return arr;
    }

    public int numPairsDivisibleBy60(int[] time) {
        int[] arr = new int[60];
        int ans = 0;
        
        for(int i = 0; i < time.length; i++){
            arr[time[i] % 60]++;
        }
        
        for(int i = 0; i <= 30; i++){
            if(i == 0 || i == 30) ans += (arr[i] * (arr[i]-1))/2;
            else ans += arr[i] * arr[60-i];
        }
        return ans;
    }
}