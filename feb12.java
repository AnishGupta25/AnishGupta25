import java.util.*;
public class feb12 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int level = 0;
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        if(!set.contains(endWord))
            return 0;
        if(set.contains(beginWord))
            set.remove(beginWord);
        q.add(beginWord);
        
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for (int i = 0; i < size; i++){
                String currentString = q.poll();
                if(currentString.equals(endWord))
                    return level;
                List<String> neighbours = neighbour(currentString);
                for(String neigh : neighbours){
                    if(set.contains(neigh)){
                        q.add(neigh);
                        set.remove(neigh);
                    }
                }
            }
        }
        return 0;
        
    }
    
    private static List<String> neighbour(String str){
        char[] chars = str.toCharArray();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++){
            char temp = str.charAt(i);
            for (char c = 'a'; c <= 'z'; c++){
                chars[i] = c;
                String neigh = new String(chars);
                list.add(neigh);
            }
            chars[i] = temp;
        }
        return list;
    }
}
