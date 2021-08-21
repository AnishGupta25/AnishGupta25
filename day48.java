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

    public static boolean IsQueenSafe(int[][] chess, int row, int col) {
        for(int i = row, j = col; i >= 0; i--){
            if(chess[i][j] != 0) return false;
        }
        
        for(int i = row, j = col; i < chess.length; i++){
            if(chess[i][j] != 0) return false;
        }
        
        for(int i = row , j = col; j >= 0; j--){
            if(chess[i][j] != 0) return false;
        }
        
        for(int i = row , j = col; j < chess.length; j++){
            if(chess[i][j] != 0) return false;
        }
        
        for(int i = row , j = col; j >= 0 && i >= 0; j-- , i--){
            if(chess[i][j] != 0) return false;
        }
        
        for(int i = row, j = col; j < chess.length && i < chess.length; j++ , i++){
            if(chess[i][j] != 0) return false;
        }
        
        for(int i = row , j = col; j < chess.length && i >= 0; j++ , i--){
            if(chess[i][j] != 0) return false;
        }
        
        for(int i = row , j = col; j >= 0 && i < chess.length; j-- , i++){
            if(chess[i][j] != 0) return false;
        }
        return true;
      }
    
      public static void nqueens(int qpsf, int tq, int[][] chess) {
        if(qpsf == tq){
            for(int i = 0; i < chess.length; i++){
                for(int j = 0; j < chess.length; j++){
                    System.out.print(chess[i][j] != 0 ? "q" +chess[i][j]+"\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
        }
        
        for(int i = 0; i < tq*tq; i++){
            int row = i / tq; 
            int col = i % tq;
            if(chess[row][col] == 0 && IsQueenSafe(chess , row , col)){
                chess[row][col] = qpsf + 1;
                nqueens(qpsf + 1 , tq , chess);
                chess[row][col] = 0;
            }
        }
      }
}
