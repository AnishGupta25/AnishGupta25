import java.util.*;
public class day99 {
    public int[][] overlappedInterval(int[][] interval){
        Arrays.sort(interval , Comparator.comparingInt(a -> a[0]));
        int endTime = interval[0][1], resultIndex = 0;
        int[][] result = new int[interval.length][2];
        result[0] = interval[0];
        for (int i = 1; i < interval.length; i++) {
            if (interval[i][1] > endTime) {
                if (interval[i][0] <= endTime) {
                    result[resultIndex][1] = interval[i][1];
                    endTime = interval[i][1];
                } else {
                    resultIndex++;
                    result[resultIndex] = interval[i];
                    endTime = interval[i][1];
                }
            }
        }
        int[][] make = new int[resultIndex + 1][2];
        for (int i = 0; i < make.length; i++)
            make[i] = result[i];
        return make;
    }
}
