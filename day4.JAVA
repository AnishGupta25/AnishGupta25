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

public static int arrSum() {
    int n1 = scn.nextInt();
    int arr1[] = new int[n1];
    for(int i = 0; i < n1; i++){
        arr1[i] = scn.nextInt();
    }
    
    int n2 = scn.nextInt();
    int arr2[] = new int[n2];
    for(int i = 0; i < n2; i++){
        arr2[i] = scn.nextInt();
    }
    
    int n = n1 > n2 ? n1 : n2;
    int sum[] = new int[n];
    
    int p1 = n1 - 1 , p2 = n2 - 1, p3 = n - 1 , carry = 0;
    
    while(p1 >= 0 || p2 >= 0 || carry > 0){
        int val1 = p1 < 0 ? 0 : arr1[p1];
        int val2 = p2 < 0 ? 0 : arr2[p2];
        
        int res = val1 + val2 + carry;
        
        sum[p3] = res % 10;
        carry = res / 10;
        
        p1--;
        p2--;
        p3--;
    }
    
    for(int i = 0; i < n; i++){
        System.out.println(sum[i]);
    }
}

public static int arrdiff() {
    int n1 = scn.nextInt();
    int a1[] = new int[n1];
    for(int i = 0; i < n1; i++){
        a1[i] = scn.nextInt();
    }
    
    int n2 = scn.nextInt();
    int a2[] = new int[n2];
    for(int i = 0; i < n2; i++){
        a2[i] = scn.nextInt();
    }
    
    int n = n1 < n2 ? n2 : n1;
    int sub[] = new int[n];
    
    int p1 = n1-1, p2 = n2-1, p3 = n-1, borrow = 0;
    
    while(p2 >= 0){
        int val1 = p1 < 0 ? 0 : a1[p1];
        int val2 = p2 < 0 ? 0 : a2[p2];
        
        int res = val2 - val1 + borrow;
        
        if(res < 0){
            res += 10;
            borrow = -1;
        }
        else{
            borrow = 0;
        }
        
        sub[p3] = res;
        
        p1--;
        p2--;
        p3--;
    }
    boolean flag = false;
    for(int i = 0; i < n; i++){
        if(sub[i] != 0){
            flag = true;
        }
        if(flag){
            System.out.println(sub[i]);
        }
        
    }
}

public static void reverse(int[] a) {
    int n = a.length;

    int p1 = 0, p2 = n - 1;
    while(p1 <= p2){
        int temp = a[p1];
        a[p1] = a[p2];
        a[p2] = temp;
        
        p1++;
        p2--;
    }
}

