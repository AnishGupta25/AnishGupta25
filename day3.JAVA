public static void main(String[] args) {

    static Node leftPal;
    public boolean IsPalindrome() {
      leftPal = this.head;
      boolean res = IsPalindromeHelper(head, 0);
      return res;
    }

    public boolean IsPalindromeHelper(Node node, int idx) {
      if (node == null) {
        return true;
      }
      boolean res = IsPalindromeHelper(node.next, idx + 1);

      if (res) {
        if (idx >= this.size / 2) {
          if (leftPal.data == node.data) {
            leftPal = leftPal.next;
            return true;
          } else {
            return false;
          }
        }
      }

      return res;
    }

    public static int getSum(int b, int n1, int n2) {
        int ans = 0;
        int pow = 1;
        int carry = 0;
        while(n1 > 0 || n2 > 0 || carry > 0){
            int val1 = n1 % 10;
            int val2 = n2 % 10;
            
            int sum = val1 + val2 + carry;
            carry = sum / b;
            sum %= b;
            
            ans += (sum * pow);
            
            pow *= 10;
            n1 /= 10;
            n2 /= 10;
        }
        
        return ans;
    }

    public static int getDifference(int b, int n1, int n2) {
        int ans = 0;
        int pow = 1;
        int borrow = 0;
    
        while (n2 > 0) {
          int val1 = n1 % 10;
          int val2 = n2 % 10;
    
          val2 = val2 + borrow;
          int sub = val2 - val1;
    
          if (val2 >= val1) {
            borrow = 0;
          }
          else {
            sub = sub + b;
            borrow = -1;
          }
    
          ans += sub * pow;
          n1 /= 10;
          n2 /= 10;
          pow *= 10;
        }
    
        return ans;
    }
    
    public static int getProduct(int b, int n1, int n2) {
        int dval1 = getValueIndecimal(n1, b);
        int dval2 = getValueIndecimal(n2, b);
        int mul = dval1 * dval2;
        int cval = getValueInBase(mul, b);
        return cval;
      }
    
      public static int getValueIndecimal(int n, int b) {
        int dec = 0;
        int temp;
        int count = 0;
    
        while (n > 0) {
          temp = n % 10;
          n = n / 10;
          dec = dec + temp * (int)Math.pow(b, count);
          count++;
        }
        return dec;
      }
      public static int getValueInBase(int n, int b) {
        int temp;
        int rv = 0;
        int pow = 1;
    
        while (n > 0) {
          temp = n % b;
          rv = rv + temp * pow;
          n = n / b;
          pow = pow * 10;
        }
        return rv;
    }
}