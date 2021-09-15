import java.util.*;
public class day73 {
    public static void sort012(int a[], int n){
        int i = 0 , j = 0 , k = n - 1;
        
        while(j <= k){
            if(a[j] == 1){
                j++;
            }
            else if(a[j] == 0){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                
                i++;
                j++;
            }
            else if(a[j] == 2){
                int temp = a[k];
                a[k] = a[j];
                a[j] = temp;
                k--;
            }
        }
    }
    public int lengthOfLongestSubstring(String s) {
        int i = -1 , j = -1;
        int ans = 0;
        HashMap<Character , Integer> map = new HashMap<>();
        
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            while(i < s.length() - 1){
                flag1 = true;
                i++;
                char ch = s.charAt(i);
                map.put(ch , map.getOrDefault(ch , 0) + 1);
                
                if(map.get(ch) > 1) break;
                else {
                    int len = i - j;
                    if(len > ans) ans = len;
                }
            }
            
            while(j < i){
                flag2 = true;
                j++;
                char ch = s.charAt(j);
                map.put(ch , map.get(ch) - 1);
                
                if(map.get(ch) == 1) break;
            }
            if(!flag1 && !flag2) break;
        }
        return ans;
    }

    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length() || s2.length() == 0) return false;
        if(s1.length() == 0) return true;
        
        int n1 = s1.length();
        int n2 = s2.length();
        
        int arr1[] = new int[26];
        int arr2[] = new int[26];
        
        for(int i = 0; i < n1; i++){
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }
        
        for(int i = n1; i < n2; i++){
            if(Arrays.equals(arr1 , arr2)) return true;
            
            arr2[s2.charAt(i - n1) - 'a']--;
            arr2[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(arr1 , arr2)) return true;
        return false;
    }

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static void reverse(ListNode start , ListNode end){
        ListNode prev = null;
        ListNode cur = start;
        
        while(cur != end){
            ListNode fwd = cur.next;
            cur.next = prev;
            prev = cur;
            cur = fwd;
        }
        cur.next = prev;
    }

    public static ListNode reverseInRange(ListNode head, int n, int m) {
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        int end = n < m ? m : n;
        int start = n < m ? n : m;
        while(end-- > 1){
            fast = fast.next;
        }
        ListNode tail = fast.next;
        while(start-- > 1){
            prev = slow;
            slow = slow.next;
        }
        reverse(slow , fast);
        if(prev == null){
            head = fast;
            slow.next = tail;
        }
        else{
            prev.next = fast;
            slow.next = tail;
        }
        
        
        return head;
    }
}
