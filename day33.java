public class day33 {
    int isPlaindrome(String S) {
        int n = S.length();
        char[] str = S.toCharArray();
        int i = 0, j = n - 1;
        while(i <= j){
            if(str[i] != str[j]) return 0;
            i++;
            j--;
        }
        return 1;
    }
}
