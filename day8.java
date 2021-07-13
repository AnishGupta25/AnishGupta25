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
    
    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        if (idx == arr.length) {
          int a[] = new int[fsf];
          return a;
        }
    
        if (arr[idx] == x) {
          int a[] = allIndices(arr, x, idx + 1, fsf + 1);
          a[fsf] = idx;
          return a;
        }
        else {
          int a[] = allIndices(arr, x, idx + 1, fsf);
          return a;
        }
    }

    
}
