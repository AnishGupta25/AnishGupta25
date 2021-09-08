public class day67 {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder str = new StringBuilder();
        long max = 0;
        for(int i = shifts.length - 1; i >= 0; i--){
            max += shifts[i];
        }
        
        for(int i = 0; i < s.length(); i++){
            long temp = s.charAt(i) - 'a' + 1;
            temp = (temp + max) % 26;
            char ch = (char)('a' + (temp - 1));
            if(temp == 0) ch = 'z';
            str.append(ch);
            max -= shifts[i];
        }
        return str.toString();
    }
}
