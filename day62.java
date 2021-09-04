public class day62 {
    public static int solution(int n, int k) {
        if(n == 1) return 0;
        return (solution(n - 1 , k) + k) % n;
    }
    
    static int counter = 1;
    public static void solution(int i, int n, boolean[] used, String asf) {
        if (i > n) {
          System.out.println(counter + "." + asf);
          counter++;
          return;
        }
        if (used[i]) {
          solution(i + 1, n, used, asf);
        }
        else {
          used[i] = true;
          solution(i + 1, n, used, asf + "(" + i + ") ");
    
          for (int j = i + 1; j <= n; j++) {
            if (!used[j]) {
              used[j] = true;
              solution(i + 1, n, used, asf + "(" + i + "," + j + ") ");
              used[j] = false;
            }
          }
          used[i] = false;
        }
    }
}
