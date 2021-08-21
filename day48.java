public class day48 {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        
        int countA = 0, countB = 0;
        
        while(a > 0 || b > 0){
            if((a >= b && countA < 2) || (a > 0 && countB == 2)){
                sb.append('a');
                a--;
                countB = 0;
                countA++;
            }
            else if((b >= a && countB < 2) || (b > 0 && countA == 2)){
                sb.append('b');
                b--;
                countA = 0;
                countB++;
            }
            else return "";
        }
        return sb.toString();
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null){
            ListNode fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
        if(qpsf == tq){
            for(int i = 0; i < chess[0].length*chess.length; i++){
                int row = i / chess[0].length;
                int col = i % chess[0].length;
                if(!chess[row][col]){
                    System.out.print("-" + "\t");
                }
                if(chess[row][col]){
                    System.out.print("q" + "\t");
                }
                if(col == chess[0].length - 1){
                    System.out.println();
                }
            }
            System.out.println();
            return;
        }
        
        for(int i = lcno+1; i < chess[0].length*chess.length; i++){
            int row = i / chess[0].length;
            int col = i % chess[0].length;
            if(!chess[row][col]){
                chess[row][col] = true;
                queensCombinations(qpsf+1 , tq , chess , i);
                chess[row][col] = false;
            }
        }
    }
}
