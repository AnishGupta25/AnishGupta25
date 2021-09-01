public class day60 {
    static int getCount(int N) {
        int count = 0;
        for (int L = 1; L * (L + 1) < 2 * N; L++) {
            double a = (double)((1.0 * N - (L * (L + 1)) / 2) / (L + 1));
            if (a - (int)a == 0.0) count++;
        }
        return count;
    }

    public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf) {
        if (i == coins.length) {
          if (amtsf == tamt) {
            System.out.println(asf + ".");
          }
          return;
        }
        coinChange(i + 1, coins, amtsf + coins[i], tamt, asf + coins[i] + "-");
        coinChange(i + 1, coins, amtsf, tamt, asf + "");
    }
}
