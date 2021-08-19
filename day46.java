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

    public String modifyString(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        
        for(int i = 0; i < n; i++){
            if(str[i] == '?' && i == 0){
                if(s.length() > 1){
                    for(char ch = 'a'; ch < 'z'; ch++){
                        if(str[i+1] != ch) str[i] = ch; 
                    }
                }
                else str[i] = 'a';
            }
            else if(str[i] == '?' && i == n-1){
                for(char ch = 'a'; ch < 'z'; ch++){
                    if(str[i-1] != ch) str[i] = ch; 
                }
            }
            else if(str[i] == '?'){
                for(char ch = 'a'; ch < 'z'; ch++){
                    if(str[i-1] != ch && str[i+1] != ch) str[i] = ch; 
                }
            }
        }
        
        return new String(str);
    }
}
