package mine.leetcode.two_sum;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sim
 * Date: 2020-12-10
 * Time: 1:42 下午
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i=0; i < nums.length; i++ ) {
            if (hash.containsKey(nums[i])) {
                indexs[0] = hash.get(nums[i]);
                indexs[1] = i;
                return indexs;
            }
            hash.put(target-nums[i],i);

        }
        return indexs;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] result = new Solution().twoSum(nums,target);
        System.out.println(result[0]+","+result[1]);
    }
}
