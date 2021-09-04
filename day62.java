public class day62 {
    public static int solution(int n, int k) {
        if(n == 1) return 0;
        return (solution(n - 1 , k) + k) % n;
    }
}
