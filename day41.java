import java.util.ArrayList;
import java.util.PriorityQueue;

public class day41 {
    public void setZeroes(int[][] matrix) {
        int col = 1;
        int n = matrix.length , m = matrix[0].length;
        
        for(int i = 0; i < n; i++){
            if(matrix[i][0] == 0) col = 0;
            for(int j = 1; j < m; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 1; j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if(col == 0) matrix[i][0] = 0;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1) return head;
        
        int size = size(head);
        if(size < k) return head;
        
        ListNode OrigHead = null;
        ListNode OrigTail = null;
        ListNode curr = head;
        
        while(size >= k){
            int tempk = k;
            while(tempk-- > 0){
                ListNode fwd = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = fwd;
            }
            if(OrigHead == null){
                OrigHead = tempHead;
                OrigTail = tempTail;
            }
            else{
                OrigTail.next = tempHead;
                OrigTail = tempTail;
            }
            size -= k;
            tempHead = null;
            tempTail = null;
        }
        OrigTail.next = curr;
        return OrigHead;
    }
    ListNode tempHead = null;
    ListNode tempTail = null;
    public void addFirst( ListNode node){
        if(tempHead == null){
            tempHead = node;
            tempTail = node;
        }
        else{
            node.next = tempHead;
            tempHead = node;
        }
    }
    
    public int size(ListNode head){
        ListNode temp = head;
        int size = 0;
        
        while(temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }

    public int findDuplicate(int[] nums) {
        int[] arr = new int[nums.length + 1];
        
        for(int i = 0; i < nums.length; i++){
            arr[nums[i]] = arr[nums[i]] + 1;
            
            if(arr[nums[i]] == 2) return nums[i];
        }
        
        return 0;
    }

    public static class Pair implements Comparable<Pair> {
        int curVtx, wt;
        String path;
        Pair(int curVtx, int wt, String path) {
          this.curVtx = curVtx;
          this.wt = wt;
          this.path = path;
        }
        public int compareTo(Pair o) {
          return this.wt - o.wt;
        }
    }
    
    public static void ShortPath(ArrayList<Edge>[] graph , int src) {
        boolean[] visited = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src , 0 , src+""));
        
        while(pq.size() > 0){
            Pair temp = pq.remove();
            
            if(!visited[temp.curVtx]){
                visited[temp.curVtx] = true;
                System.out.println(temp.curVtx + " via " + temp.path + " @ " + temp.wt);
                
                for(Edge e : graph[temp.curVtx]){
                    if(!visited[e.nbr]){
                        pq.add(new Pair(e.nbr , temp.wt + e.wt , temp.path + e.nbr));
                    }
                }
            }
        }
    }

    public static ArrayList<Integer> duplicates(int arr[], int n) {
        ArrayList<Integer> res = new ArrayList<>();
        int a[] = new int[n];
        for(int j = 0; j < n; j++){
            a[arr[j]] = a[arr[j]] + 1;
        }
        for(int i = 0; i < n; i++){
            if(a[i] > 1){
                res.add(i);
            }
        }
        if(res.isEmpty()){
            res.add(-1);
        }
        
        return res;
    }

    public int peakElement(int[] arr,int n){
        if(n == 1) return 0;
        if(arr[0] >= arr[1]) return 0;
        if(arr[n-1] >= arr[n-2]) return n-1;
        
        for(int i = 1; i < n-1; i++){
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]) return i;
        }
        return 0;
    }

    static int trappingWater(int arr[], int n) { 
        if(n <= 2) return 0;
        
        int left[] = new int[n];
        left[0] = arr[0];
        for(int i = 1; i < n; i++){
            left[i] = Math.max(left[i-1] , arr[i]);
        }
        
        int right[] = new int[n];
        right[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--){
            right[i] = Math.max(right[i+1] , arr[i]);
        }
        
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += Math.min(left[i] , right[i]) - arr[i];
        }
        
        return sum;
    } 
}
