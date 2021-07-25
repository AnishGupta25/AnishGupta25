public class day23 {
    static int canRepresentBST(int arr[], int N) {
        Stack<Integer> st = new Stack<>();
        int root = Integer.MIN_VALUE;
        
        for(int i = 0; i < N; i++){
            if(arr[i] < root) return 0;
            
            while(st.size() > 0 && st.peek() < arr[i]){
                root = st.peek();
                st.pop();
            }
            st.push(arr[i]);
        }
        return 1;
    }
}
