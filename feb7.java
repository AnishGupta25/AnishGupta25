public class feb7 {
    public char findTheDifference(String s, String t) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            ans -= (int)(s.charAt(i) - 'a');
            ans += (int)(t.charAt(i) - 'a');
        }
        ans += (int)t.charAt(t.length() - 1);
        return (char)(ans);
    }
}
