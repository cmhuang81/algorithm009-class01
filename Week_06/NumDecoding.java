class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len+1];
        dp[len] = 1;
        if (s.charAt(len-1) != '0') {
            dp[len-1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            int res1 = dp[i+1];
            int res2 = 0;
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            if (ten + one <= 26) {
                res2 = dp[i + 2];
            }
            dp[i] = res1 + res2;
        }
        return dp[0];
    }

    // private int getRes(String s, int start, HashMap<Integer, Integer> memoization) {
    //     if (start == s.length()) {
    //         return 1;
    //     }

    //     if (s.charAt(start) == '0') {
    //         return 0;
    //     }
    //     int res = memoization.getOrDefault(start, -1);
    //     if (res != -1) {
    //         return res;
    //     }
    //     int res1 = getRes(s, start + 1, memoization);
    //     int res2 = 0;

    //     if (start < s.length() - 1) {
    //         int ten = 10 * (s.charAt(start) - '0');
    //         int sin = s.charAt(start + 1) - '0';
    //         if (26 >= ten + sin) {
    //             res2 = getRes(s, start + 2, memoization);
    //         }
    //     }
    //     memoization.put(start, res1 + res2);
    //     return res1 + res2;
    // }
}