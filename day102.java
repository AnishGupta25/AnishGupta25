public class day102 {
    public static int swapBits(int n) {
        long ans = 0;
        for(int i=0;i<32;i+=2) {
            ans |= ((1<<(i+1))&n)>>1;
            ans |= ((1<<i)&n)<<1;
        }
        return (int) ans;
	}
}
