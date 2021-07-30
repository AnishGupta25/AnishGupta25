public class day28 {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> res = new ArrayList<>();
        int carry = 0;
        for(int i = digits.length - 1; i >= 0; i--){
            int nums = digits[i] + carry;
            if(i == digits.length - 1){
                nums += 1;
            }
            carry = nums / 10;
            nums = nums%10;
            res.add(0 , nums);
        }
        if(carry != 0){
            res.add(0 , carry);
        }
        int[] r = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            r[i] = res.get(i);
        }
        return r;
    }
}
