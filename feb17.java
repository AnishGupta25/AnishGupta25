import java.util.*;
public class feb17 {
    List<List<Integer>> resultList = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] arr, int target) {
            
        getTargetCombination(arr, 0, target, new ArrayList<Integer>());
        return resultList;
    }
    
    
    public void getTargetCombination(int[] arr, int position, int currentTarget, List<Integer> result) {
        if (currentTarget == 0) {
            resultList.add(new ArrayList<>(result));
            return;
        }
        if (position == arr.length) {
            return;
        }
        if (arr[position] <= currentTarget) {
            result.add(arr[position]);
            getTargetCombination(arr, position, currentTarget - arr[position], result);
            result.remove(result.size() - 1);
        }
        getTargetCombination(arr, position + 1, currentTarget, result);
    }
}
