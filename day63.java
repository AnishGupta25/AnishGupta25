import java.util.*;
public class day63 {
    static int findLongestConseqSubseq(int arr[], int N){
	    HashSet<Integer> set = new HashSet<>();
	    for(int i = 0; i < N; i++){
	        set.add(arr[i]);
	    }
	    int count = 0;
	    
	    for(int i = 0; i < N; i++){
	        if(!set.contains(arr[i] - 1)){
	            int temp = arr[i];
	            while(set.contains(temp)){
	                temp++;
	            }
	            if(count < temp - arr[i]){
	                count = temp - arr[i];
	            }
	        }
	    }
	    return count;
	}

	public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : hand){
            pq.add(i);
        }
        
        while(!pq.isEmpty()){
            int head = pq.poll();
            
            for(int i = 1; i < groupSize; i++){
                if(!pq.remove(head+i)) return false;
            }
        }
        return true;
    }

	public static void solution(String unique, int idx, HashMap<Character, Integer> charIntMap, boolean[] usedNumbers, String s1, String s2, String s3) {
		if(idx == unique.length()){
			int num1 = getNumber(s1 , charIntMap);
			int num2 = getNumber(s2 , charIntMap);
			int num3 = getNumber(s3 , charIntMap);
			
			if(num1 + num2 == num3){
				for(int i = 0; i < 26; i++){
					char ch = (char)(i + 'a');
					if(charIntMap.containsKey(ch)){
						System.out.print(ch+"-"+charIntMap.get(ch) +" ");
					}
				}
				System.out.println();
			}
			return;
		}
		char ch = unique.charAt(idx);
		for(int i = 0; i < 10; i++){
			if(!usedNumbers[i]){
				usedNumbers[i] = true;
				charIntMap.put(ch , i);
				solution(unique, idx+1, charIntMap, usedNumbers, s1, s2, s3);
				usedNumbers[i] = false;
				charIntMap.remove(ch);
			}
		}
	}
	  
	public static int getNumber(String str , HashMap<Character, Integer> charIntMap){
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < str.length();i++){
			char ch = str.charAt(i);
			sb.append(charIntMap.get(ch));
		}
		return Integer.parseInt(sb.toString());
	}
}
