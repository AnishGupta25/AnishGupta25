import java.util.*;
public class dec16 {
    class Solution {
        static final int MAX_ADJACENT = 20;
        
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            if (n < 2) return Arrays.asList((n == 1) ?  (new Integer[]{0}) : (new Integer[]{0,1}));
            
            int[] adjacentRemaining = new int[n];
            int[][] adjacentList = new int[n][MAX_ADJACENT];
            for (int[] edge : edges) {          
                adjacentList[edge[0]][adjacentRemaining[edge[0]]++] = edge[1];
                adjacentList[edge[1]][adjacentRemaining[edge[1]]++] = edge[0];
            }
            int[] adjacentCount = Arrays.copyOf(adjacentRemaining, n);
            int[] leafs = new int[n];
            int leafCount = 0;
            int nextLeafCount = 0;
            for (int i = n - 1; i >= 0; i--)
                if (adjacentRemaining[i] == 1) leafs[nextLeafCount++] = i;
            
            int nodesRemaining = n;
            boolean[] nodeRemoved = new boolean[n];
            while (nodesRemaining > 2) {
                leafCount = nextLeafCount;
                nextLeafCount = 0;
                nodesRemaining -= leafCount;
                for (int leafIdx = 0; leafIdx < leafCount; leafIdx++) {
                    int node = leafs[leafIdx];
                    int adjacentNode = -1;
                    for (int i = adjacentCount[node] - 1; i >= 0; i--) {
                        if (!nodeRemoved[adjacentList[node][i]]) {
                            adjacentNode = adjacentList[node][i];
                            break;
                        }
                    }
                    nodeRemoved[node] = true;
                    if (--adjacentRemaining[adjacentNode] == 1) leafs[nextLeafCount++] = adjacentNode;
                }
            }
            return Arrays.asList((nextLeafCount == 1) ? (new Integer[]{leafs[0]}) :  (new Integer[]{leafs[0], leafs[1]}));
        }
    }
}
