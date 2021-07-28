import java.util.Arrays;

public class day25{
    public int numRescueBoats(int[] people, int limit) {
        int numofboats = 0;
        Arrays.sort(people);
        int start = 0, end = people.length - 1;
        while(start <= end){
            numofboats++;
            if(people[start] + people[end] <= limit){
                start++;
            }
            end--;
        }
        return numofboats;
    }

    int oddsum = 0;
    int evensum = 0;
	int getLevelDiff(Node root){
	    
	    getsum(root , 1);
	    return oddsum - evensum;
	}
	
	void getsum(Node node , int level){
	    if(node == null) return;
	    
	    if(level % 2 != 0){
	        oddsum += node.data;
	    }
	    if(level % 2 == 0){
	        evensum += node.data;
	    }
	    level += 1;
	    getsum(node.left,level);
	    getsum(node.right , level);
	}
}