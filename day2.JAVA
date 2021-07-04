public class main{
    public static void main(String[] args) {
        
    }
    
    public static int getDigitFrequency(int n, int d) {
        int count = 0;
        while(n > 0){
            int num = n % 10;
            if(num == d){
                count++;
            }
            n = n / 10;
        }
        return count;
    }

    

}
