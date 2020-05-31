import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (59.87%)
 * Likes:    195
 * Dislikes: 0
 * Total Accepted:    103.2K
 * Total Submissions: 171.9K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap tmp = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if (tmp.containsKey(s.charAt(i))) {
                tmp.put(s.charAt(i), (int)tmp.get(s.charAt(i))+1);
            } else {
                tmp.put(s.charAt(i),1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (tmp.containsKey(t.charAt(i))) {
                if ((int)tmp.get(t.charAt(i)) == 1) {
                    tmp.remove(t.charAt(i));
                } else {
                    tmp.put(t.charAt(i), (int)tmp.get(t.charAt(i))-1);
                }                
            } else {
                return false;
            }
        }

        return tmp.isEmpty();
    }
}
// @lc code=end