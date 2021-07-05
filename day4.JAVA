public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
        arr[i] = scn.nextInt();
    }

    int max = maxofarr(arr, n);
    int min = minofarr(arr, n);

    int span = max - min;
    System.out.print(span);
}

public static int maxofarr(int arr[], int n) {
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < n; i++){
        if(arr[i] > max){
            max = arr[i];
        }
    }
    return max;
}

public static int minofarr(int arr[], int n) {
    int min = Integer.MAX_VALUE;
    for(int i = 0; i < n; i++){
        if(arr[i] < min){
            min = arr[i];
        }
    }
    return min;
}

public static void findElement(int arr[] , int d , int n) {
    for (int i = 0; i < n; i++) {
      if (arr[i] == d) {
        System.out.print(i);
        return;
      }
    }

    System.out.print("-1");
}

public static void barchart(int arr[], int n, int max) {
    for (int i = 1; i <= max; i++) {
      for (int j = 0; j < n; j++) {
        if (max - arr[j] < i) {
          System.out.print("*\t");
        }
        else {
          System.out.print("\t");
        }
      }
      System.out.println();
    }
}
