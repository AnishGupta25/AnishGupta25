public class day8 {
    public static int lastIndex(int[] arr, int idx, int x) {
        if (idx < 0) {
          return -1;
        }
    
        if (arr[idx] == x) {
          return idx;
        }
        else {
          int lst = lastIndex(arr, idx - 1, x);
          return lst;
        }
    }

    public static int firstIndex(int[] arr, int idx, int x) {
        if (idx == arr.length) {
          return -1;
        }
    
        if (arr[idx] == x) {
          return idx;
        }
        else {
          int fst = firstIndex(arr, idx - 1, x);
          return fst;
        }
    }    
}
