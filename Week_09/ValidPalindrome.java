class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        for ( ;left < right & s.charAt(left) == s.charAt(right); ++left, --right);
        return palindrome(s, left + 1, right) || palindrome(s, left, right - 1);
    }

    private boolean palindrome(String s, int left, int right) {
        for ( ;left < right & s.charAt(left) == s.charAt(right); ++left, --right);
        return left >= right;
    }
}