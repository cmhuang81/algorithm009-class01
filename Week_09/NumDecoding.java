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
}