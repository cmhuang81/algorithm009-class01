/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int result = nums.length;
        int step = 0;
        for (int i = 1;i < nums.length;i++){
            int v = nums[i];
            if (v == nums[step]) {
                result = result -1;
            } else {
                step = step +1;
                nums[step] = nums[i];            
            }
        }
        return result;
    }
}
// @lc code=end