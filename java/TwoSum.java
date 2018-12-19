import java.util.HashMap;
import java.util.Map;

/**
 * @author Yang on 19/12/2018.
 * @version 1.0
 */
/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        Example:

        Given nums = [2, 7, 11, 15], target = 9,

        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].
        */
public class TwoSum {

    //time complexity O(n2)
    //space complexity O(1)
    public int[] findTwoNumber(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    //using hashMap
    public int[] findTwoNumberUsingHashMap(int[] nums, int target) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numberMap.put(target - nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            if (numberMap.containsKey(nums[j]) && (j != numberMap.get(nums[j]))) {
                return new int[] {numberMap.get(nums[j]), j};
            }
        }
        return null;
    }

    //using hashMap and only iterate once
    public int[] findTwoNumberUsingIterateOnce(int[] nums, int target) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numberMap.containsKey(complement)) {
                return new int[] {numberMap.get(complement), i};
            }
            numberMap.put(nums[i], i);
        }
        return null;
    }
}
