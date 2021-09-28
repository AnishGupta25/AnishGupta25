import java.util.*;
public class day86 {
    public void sortColors(int[] nums) {
        if(nums.length == 1) return;
        
        int i = 0, j = 0 ,k = nums.length-1;
        
        while(i <= k){
            if(nums[i] == 1){
                i++;
            }
            else if(nums[i] == 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
                i++;
            }
            else{
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k--;
            }
        }
    }

    public Stack<Integer> sort(Stack<Integer> s){
	    if(!s.isEmpty()){
	        sortst(s);
	    }
	    return s;
	}
	
	public void sortst(Stack<Integer> st){
	    if(!st.isEmpty()){
	        int temp = st.pop();
	        sortst(st);
	        InsertSort(st , temp);
	    }
	}
	public void InsertSort(Stack<Integer> st , int elm){
	    if(st.isEmpty() || st.peek() < elm){
	        st.push(elm);
	        return;
	    }
	    
	    int temp = st.pop();
	    InsertSort(st , elm);
	    st.push(temp);
	}
}
