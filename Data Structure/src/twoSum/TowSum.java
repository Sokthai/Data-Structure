package twoSum;
import java.util.HashMap;
import java.util.Map;

public class TowSum {
	
	
	
	/**
	 * Date: May/9/20 
	 * Run Time: n^2
	 * Note: brute force is working, but not acceptable
	 */
	
	public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
		int n = 0;
		
		for (int i = 0; i < nums.length; i++) {
			n = target - nums[i];
			result[0] = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == n) {
					 result[1] = j;
					 return result;
				}
			}
		}
		return result;
    }
	
	
	
	public int[] twoSumHash(int[] nums, int target) {
		int result[] = new int[2];
		Map<Integer, Integer> hash = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			hash.put(nums[i], i);
		}
		
		
		for (int i = 0; i < nums.length; i++) {
			int r = target - nums[i];
			if (hash.containsKey(r) && hash.get(r) != i) {
				result[0] = i;
				result[1] = hash.get(r);
				return result;
			}
			
		}
		return result;
	}
	
}
 