public class day60 {
    static int getCount(int N) {
        int count = 0;
        for (int L = 1; L * (L + 1) < 2 * N; L++) {
            double a = (double)((1.0 * N - (L * (L + 1)) / 2) / (L + 1));
            if (a - (int)a == 0.0) count++;
        }
        return count;
    }

    public static void coinChange1(int i, int[] coins, int amtsf, int tamt, String asf) {
        if (i == coins.length) {
          if (amtsf == tamt) {
            System.out.println(asf + ".");
          }
          return;
        }
        coinChange1(i + 1, coins, amtsf + coins[i], tamt, asf + coins[i] + "-");
        coinChange1(i + 1, coins, amtsf, tamt, asf + "");
    }

    public static void coinChange2(int i, int[] coins, int amtsf, int tamt, String asf) {
      if(i == coins.length){
          if(amtsf == tamt){
              System.out.println(asf+".");
          }
          return;
      }
      
      for(int k = tamt / coins[i]; k > 0; k--){
          String psf = "";
          for(int j = 0; j < k; j++){
              psf += coins[i]+"-";
          }
          coinChange2(i+1 , coins , amtsf+coins[i]*k , tamt , asf+psf);
      }
      coinChange2(i+1 , coins , amtsf , tamt , asf);
    }

    public static void coinChange3(int[] coins, int amtsf, int tamt, String asf, boolean[] used) {
      if(amtsf == tamt){
          System.out.println(asf+".");
          return;
      }
      
      for(int i = 0; i < coins.length; i++){
          if(!used[i]){
              used[i] = true;
              coinChange3(coins , amtsf + coins[i], tamt , asf+coins[i]+"-" , used);
              used[i] = false;
          }
      }
    }
}
