import java.util.Stack;

public class day36 {
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3) return false;
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            min[i] = Math.min(min[i - 1] , nums[i]);
        }
        
        Stack<Integer> st = new Stack<>();
        
        for(int j = nums.length - 1; j >= 0; j--){
            while(st.size() > 0 && st.peek() <= min[j]) st.pop();
            if(st.size() > 0 && st.peek() < nums[j]) return true;
            st.push(nums[j]);
        }
        return false;
    }

    public String interpret(String command) {
        int n = command.length() , i = 0;
        StringBuilder sb = new StringBuilder(n);
        
        while(i < n){
            if(command.charAt(i) == 'G'){
                sb.append("G");
                i++;
            }
            else if(command.charAt(i + 1) == ')'){
                sb.append("o");
                i += 2;
            }
            else{
                sb.append("al");
                i += 4;
            }
        }
        return sb.toString();
    }

    public String addStrings(String num1, String num2) {
        int n = num1.length() , m = num2.length() , i = n-1 , j = m-1;
        int carry = 0; 
        StringBuilder sb = new StringBuilder();
        
        while(i >= 0 || j >= 0 || carry > 0){
            int v1 = (i >= 0) ? (num1.charAt(i) - '0') : 0;
            int v2 = (j >= 0) ? (num2.charAt(j) - '0') : 0;
            
            int temp = v1 + v2 + carry;
            carry = temp / 10;
            temp %= 10;
            
            sb.insert(0 , temp);
            i--;
            j--;
        }
        return sb.toString();
    }
}
