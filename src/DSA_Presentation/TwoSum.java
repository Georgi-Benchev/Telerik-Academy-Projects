package DSA_Presentation;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {

            for (int j = 0; j < nums.length; j++) {
                for (int i = j + 1; i < nums.length; i++) {

                    if (nums[j] + nums[i] == target) {
                        return new int[]{j, i};
                    }
                }
            }

            return null;
        }

    }




// [3,2,4], target = 6
    static class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> numbers = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {

                if (numbers.containsKey(nums[i])) {
                    return new int[]{numbers.get(nums[i]), i};
                } else {
                    numbers.put(target - nums[i], i);
                }
            }

            return null;
        }

    }
}
