public class jan28 {
    class WordDictionary {
        class Node{
            Node[] childs;
            boolean isEnd;
            Node()
            {
                childs = new Node[26];
            }
            boolean find(String word,int i)
            {
                if(i == word.length())
                    return isEnd;
                if(word.charAt(i) == '.')
                {
                    for(Node child : childs)
                    {
                        if(child != null && child.find(word,i+1))
                            return true;
                    }
                    return false;
                }
                else
                {
                    if(childs[word.charAt(i)-'a'] == null)
                        return false;
                    else    return childs[word.charAt(i)-'a'].find(word,i+1);
                }
            }
            
        }
        Node root ;
        public WordDictionary() {
            root = new Node();
        }
        
        public void addWord(String word) {
            Node curr = root;
            for(int i=0;i<word.length();i++)
            {
                char ch = word.charAt(i);
                if(curr.childs[ch-'a'] == null)
                    curr.childs[ch-'a'] = new Node();
                curr = curr.childs[ch-'a'];
            }
            curr.isEnd = true;
        }
        
        public boolean search(String word) {
            return root.find(word,0);
        }
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        
        int lo = 0 , hi = n - 1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[lo] <= nums[mid]){
                if(nums[lo] <= target && nums[mid] >= target) hi = mid - 1;
                else lo = mid + 1;
            }
            else if(nums[mid] <= nums[hi]){
                if(nums[mid] <= target && nums[hi] >= target) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return -1;
    }
}
