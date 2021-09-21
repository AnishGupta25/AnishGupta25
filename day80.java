public class day80 {
    static int repeatedStringMatch(String A, String B) { 
	    int ans = 1;
	    String str = A;
	    while(str.length() < B.length()){
	        str += A;
	        ans++;
	    }
	    if(isSubstring(str , B)) return ans;
	    if(isSubstring(str+A , B)) return ans+1;
	    
	    return -1;
	} 
	
	static boolean isSubstring(String str , String B){
	    int n = str.length() , m = B.length();
	    
	    for(int i = 0; i <= n - m; i++){
	        int j;
	        for(j = 0; j < m; j++){
	            if(str.charAt(i+j) != B.charAt(j)) break;
	        }
	        if(j == m) return true;
	    }
	    return false;
	}
}
