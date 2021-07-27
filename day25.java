import java.util.Arrays;

public class day25{
    public int numRescueBoats(int[] people, int limit) {
        int numofboats = 0;
        Arrays.sort(people);
        int start = 0, end = people.length - 1;
        while(start <= end){
            numofboats++;
            if(people[start] + people[end] <= limit){
                start++;
            }
            end--;
        }
        return numofboats;
    }
}