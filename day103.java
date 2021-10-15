import java.util.*;
public class day103 {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n){
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        permute(arr,0,n-1,res);
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {    
        @Override
        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            int k=0;
            while(o1.get(k)==o2.get(k))
            k++;
            return o1.get(k).compareTo(o2.get(k));
        }           
        });
        return res;
    }
    public static void permute(ArrayList<Integer> arr ,int cur,int n,ArrayList<ArrayList<Integer>> res){
        if(cur==n){
            ArrayList<Integer> temp=new ArrayList<>(arr);
            res.add(temp);
            return;
        }
        HashSet<Integer> hset=new HashSet<>();
        for(int i=cur;i<=n;i++){
            swap(arr,cur,i);
            
            if(!hset.contains(arr.get(cur)))
            {
                hset.add(arr.get(cur));
                permute(arr,cur+1,n,res);
            }
            swap(arr,cur,i);
        }
        hset.clear();
        return;
    }
    public static void swap(ArrayList<Integer> arr,int i,int j){
        int temp=arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
        return;
    }
}
