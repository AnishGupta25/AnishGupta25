public class day96 {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public char nextGreatestLetter(char[] let, char tar) {
        if(tar >= let[let.length - 1]) return let[0];
        
        int i = 0 , j = let.length - 1;
        
        while(i <= j){
            int mid = i + (j-i) / 2;
            
            if(let[mid] <= tar) i = mid + 1;
            else j =  mid - 1;
        }
        return let[i];
    }
}
