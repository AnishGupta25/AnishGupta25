import java.util.*;
public class jan8 {
    public int majorityElement(int[] nums) {
        int idx = 0 , freq = 1;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[idx]) freq++;
            else freq--;
            
            if(freq < 0){
                idx = i;
                freq = 1;
            }
        }
        return nums[idx];
    }
    public List<Integer> majorityElement2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int num1 = -1 , num2 = -1 , count1 = 0 , count2 = 0;
        
        for(int elem : nums){
            if(elem == num1) count1++;
            else if(elem == num2) count2++;
            else if(count1 == 0){
                num1 = elem;
                count1 = 1;
            } 
            else if(count2 == 0){
                num2 = elem;
                count2 = 1;
            } 
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int elem : nums){
            if(elem == num1) count1++;
            if(elem == num2) count2++;
        }
        if(count1 > nums.length / 3) res.add(num1);
        if(count2 > nums.length / 3 && num1 != num2) res.add(num2);
       
        return res;
    }
}
