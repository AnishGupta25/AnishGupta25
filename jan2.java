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
}