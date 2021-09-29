public class day88 {
    static int candies(int m, int n){
        int x = (n * m) - n - m;
        return (x / 2) + 1;
    }
}
