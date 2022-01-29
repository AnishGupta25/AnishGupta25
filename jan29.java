import java.util.*;
public class jan29 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        
        int[] pre = getPrevSmaller(heights, n);
        int[] next = getNextSmaller(heights, n);
        
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            max = Math.max(max, (next[i] - pre[i] - 1) * heights[i]);
        }
        return max;
    }
    
    private int[] getPrevSmaller(int[] a, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && a[i] <= a[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                pre[i] = -1;
            } else {
                pre[i] = stack.peek();
            }
            stack.push(i);
        }
        return pre;
    }
    
    private int[] getNextSmaller(int[] a, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] next = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && a[i] <= a[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                next[i] = n;
            } else {
                next[i] = stack.peek();
            }
            stack.push(i);
        }
        return next;
    }
}
