import java.util.*;
public class jan24 {
    public void customSort (int phy[], int chem[], int math[], int N){
        RC[] arr = new RC[N];
        for(int i = 0; i < N; i++){
            arr[i] = new RC(phy[i],chem[i],math[i]);
        }
        
        Arrays.sort(arr);
        
        for(int i = 0; i < N; i++){
            phy[i] = arr[i].p;
            chem[i] = arr[i].c;
            math[i] = arr[i].m;
        }
    }
    public static class RC implements Comparable<RC>{
        int p , c , m;
        
        RC(int p , int c , int m){
            this.p = p;
            this.c = c;
            this.m = m;
        }
        public int compareTo(RC o){
            if(this.p != o.p) return this.p - o.p;
            else if(this.c != o.c) return o.c - this.c;
            else return this.m - o.m;
        }
    }
}
