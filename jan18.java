public class jan18 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int total = 0;
        for(int i = 0; i < flowerbed.length && total < n; i++){
            if(flowerbed[i] == 0){
                int nxt = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
                int prev = (i == 0) ? 0 : flowerbed[i - 1];
                if(nxt == 0 && prev == 0){
                    flowerbed[i] = 1; 
                    total++;
                }
            }
        }
        return total == n;
    }
}
