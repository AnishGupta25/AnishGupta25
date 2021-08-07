import java.util.HashMap;

public class day34 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int arr[] = new int[2];
        HashMap<Integer , Integer> hm = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(hm.containsKey(target - nums[i])){
                arr[0] = i;
                arr[1] = hm.get(target - nums[i]);
                break;
            }
            hm.put(nums[i] , i);
        }
        return arr;
    }

    public boolean areOccurrencesEqual(String s) {
        HashMap<Character , Integer> hm = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(hm.containsKey(ch)){
                hm.put(ch , hm.get(ch) + 1);
            }
            else{
                hm.put(ch , 1);
            }
        }
        
        int freq = hm.get(s.charAt(0));
        for(char key : hm.keySet()){
            if(freq != hm.get(key)) return false;
        }
        
        return true;
    }

    public boolean areOccurrencesEqua(String s) {
        int freq[] = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        int fre = freq[s.charAt(0) - 'a'];
        
        for(int num : freq){
            if(num != 0 && num != fre) return false;
        }
        return true;
    }
}
