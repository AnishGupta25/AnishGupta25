public class day70 {
    public void moveZeroes(int[] nums) {
        if(nums.length == 1) return;
        int i = 0; int j = 0;
        
        while(i < nums.length){
            if(nums[i] == 0){
                i++;
            }
            else if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        
        int i = 0, j = nums.length - 1;
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum == target){
                ans[0] = i + 1;
                ans[1] = j + 1;
                break;
            }
            else if(sum > target) j--;
            else i++;
        }
        return ans;
    }

    public String reverseWords(String s) {
        String[] str = s.trim().split("\\s+");
        if(str.length == 0 || str.length == 1) return s;
        int i = 0 , j = str.length - 1;
        
        while(i <= j){
            String temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str[0]);
        
        for(int k = 1; k < str.length; k++){
            sb.append(" " + str[k]);
        }
        
        return sb.toString();
    }

    public static void solution(char[][] arr, String[] words, int vidx) {
        if (vidx == words.length) {
          print(arr);
          return;
        }
        String word = words[vidx];
    
        for (int i = 0; i < arr.length; i++) {
          for (int j = 0; j < arr[0].length; j++) {
            if (arr[i][j] == '-' || arr[i][j] == word.charAt(0)) {
              if (canPlaceHorizontal(arr, word, i, j)) {
                boolean vis[] = new boolean[word.length()];
                PlaceHorizontal(arr, word, i, j, vis);
                solution(arr, words, vidx + 1);
                unPlaceHorizontal(arr, word, i, j, vis);
              }
              if (canPlaceVertical(arr, word, i, j)) {
                boolean vis[] = new boolean[word.length()];
                PlaceVertical(arr, word, i, j, vis);
                solution(arr, words, vidx + 1);
                unPlaceVertical(arr, word, i, j, vis);
              }
            }
          }
        }
    }
    
    public static boolean canPlaceHorizontal(char[][] arr, String word, int i, int j) {
        int wordptr = 0, placeprt = j;
    
        while (wordptr < word.length()) {
          if (placeprt == arr[0].length || arr[i][placeprt] == '+') return false;
    
          if (arr[i][placeprt] == '-' || arr[i][placeprt] == word.charAt(wordptr)) {
            placeprt++;
            wordptr++;
          }
          else return false;
        }
        if ((j == 0 || arr[i][j - 1] == '+') && (placeprt == arr[0].length ||  arr[i][placeprt] == '+')) return true;
        return false;
    }
    public static void PlaceHorizontal(char[][] arr, String word, int i, int j, boolean vis[]) {
        for(int idx = 0,placeptr = j; idx < word.length(); idx++, placeptr++){
            char ch = word.charAt(idx);
            if(arr[i][placeptr] == '-'){
                vis[idx] = true;
                arr[i][placeptr] = ch;
            }
        }
    }
    public static void unPlaceHorizontal(char[][] arr, String word, int i, int j, boolean vis[]) {
        for(int idx = 0,placeptr = j; idx < word.length(); idx++, placeptr++){
            if(vis[idx]){
                arr[i][placeptr] = '-';
            }
        }
    }
    
    public static boolean canPlaceVertical(char[][] arr, String word, int i, int j) {
        int wordptr = 0, placeprt = i;
    
        while (wordptr < word.length()) {
          if (placeprt == arr.length || arr[placeprt][j] == '+') return false;
    
          if (arr[placeprt][j] == '-' || arr[placeprt][j] == word.charAt(wordptr)) {
            placeprt++;
            wordptr++;
          }
          else return false;
        }
        if ((i == 0 || arr[i - 1][j] == '+') && (placeprt == arr[0].length ||  arr[placeprt][j] == '+')) return true;
        return false;
    }
    public static void PlaceVertical(char[][] arr, String word, int i, int j, boolean vis[]) {
        for(int idx = 0,placeptr = i; idx < word.length(); idx++, placeptr++){
            char ch = word.charAt(idx);
            if(arr[placeptr][j] == '-'){
                vis[idx] = true;
                arr[placeptr][j] = ch;
            }
        }
    }
    public static void unPlaceVertical(char[][] arr, String word, int i, int j, boolean vis[]) {
        for(int idx = 0,placeptr = i; idx < word.length(); idx++, placeptr++){
            if(vis[idx]){
                arr[placeptr][j] = '-';
            }
        }
    }
    
    public static void print(char[][] arr) {
        for (int i = 0 ; i < arr.length; i++) {
          for (int j = 0 ; j < arr.length; j++) {
            System.out.print(arr[i][j]);
          }
          System.out.println();
        }
    }
}
