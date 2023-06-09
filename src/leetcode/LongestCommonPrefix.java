package leetcode;

import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        String result = strs[0];

        for (int i = 1; i < strs.length - 1; i++) {
            if (strs[0].length() < strs[i].length()) swap(strs, 0, i);
        }

        for (int i = 1; i < strs.length - 1; i++) {
            if (result.isEmpty()) return "";
            if (!strs[i].startsWith(result)) {
                i = 1;
                result = result.substring(0, result.length() - 1);
            }
        }

        return result;
    }

    public void swap(String[] str, int i, int j) {
        String temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
