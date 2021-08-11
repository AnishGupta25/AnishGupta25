public class day39 {
    void nextGreatest(int arr[], int n) {
        int maxR = arr[n - 1];
        arr[n - 1] = -1;
        for(int i = n - 2; i >= 0; i--){
            int temp = arr[i];
            arr[i] = maxR;
            if(temp > maxR){
                maxR = temp;
            }
        }
    }
}
