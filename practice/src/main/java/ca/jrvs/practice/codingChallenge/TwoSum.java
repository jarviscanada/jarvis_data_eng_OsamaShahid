package ca.jrvs.practice.codingChallenge;

import java.util.HashMap;

public class TwoSum {

  /**
   * The time complexity is O(n^2) and space complexity is O(1). Since we have have to iterate through
   * all the array values twice, within the nested loop. Loop throuhg each integer value 'n' times, we have polynomial
   * time complexity. Also we do not use any other data structure/space so we have O(1) space complexity.
   * @param nums
   * @param target
   * @return
   */
  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++){
      for (int j = i+1; j < nums.length; j++){
        int total = nums[i] + nums[j];
        if (total == target){
          return new int[]{i,j};
        }
      }
    }
    return null;
  }

  public int[] twoSumOptimal(int[] nums, int target) {

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0 ; i< nums.length; i++){

      int num = target - nums[i];

      if (map.containsKey(num)){
        return new int[]{map.get(num), i};
      } else {
        map.put(nums[i], i);
      }

    }
    return null;
  }



}
