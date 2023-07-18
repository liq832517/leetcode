package leetcode;


public class longestPalindrome {
    int left = 0;
    int right = 0;
    int maxLength = 0;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            extend(s.toCharArray(), i, i, s.length());
            extend(s.toCharArray(), i, i + 1, s.length());
        }

        return s.substring(left, left + maxLength);

    }

    private void extend(char[] chars, int i, int j, int n) {
        while (i >= 0 && j < n && chars[i] == chars[j]) {
            if (maxLength < j - i + 1) {
                right = j;
                left = i;
                maxLength = j - i + 1;
            }
            i--;
            j++;
        }
    }

    public static void main(String[] args) {
        longestPalindrome longestPalindrome = new longestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("abcac"));
    }

}
