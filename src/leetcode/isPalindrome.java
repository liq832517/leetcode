package leetcode;

public class isPalindrome {
    public boolean isPalindrome(int x) {

        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int ans = 0;
        while (x > ans) {
            int pop = x % 10;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans == x || ans / 10 == x;//考虑奇数位和偶数位
    }
}
