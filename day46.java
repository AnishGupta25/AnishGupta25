public class day46 {
    public int countGoodRectangles(int[][] rectangles) {
        int arr[] = new int[rectangles.length];
        int maxLen = 0;
        for(int i = 0; i < rectangles.length; i++){
            arr[i] = Math.min(rectangles[i][0] , rectangles[i][1]);
            if(arr[i] > maxLen) maxLen = arr[i];
        }
        int count = 0;
        for(int i = 0; i < rectangles.length; i++){
            if(arr[i] == maxLen) count++;
        }
        return count;
    }
}
