/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap map = new HashMap();
        for (int x = 0;x < nums.length;x++) {
            int result = target - nums[x];
            if (map.containsKey(result)) {
                return new int[]{(int)map.get(result), x};
            }
            map.put(nums[x],x);
        }
    return null;
    }
}
// @lc code=end