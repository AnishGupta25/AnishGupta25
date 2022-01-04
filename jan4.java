public class jan4 {
    public int bitwiseComplement(int num) {
        int cur = 1;
        while (cur < num) cur = (cur << 1) | 1;
        return cur ^ num;
    }
}
