package leetcode;

import java.util.ArrayList;
import java.util.List;

public class letterCombinations {
    private List<String> result;
    private StringBuilder path;
    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        int len = digits.length();
        if (len == 0) return result;
        path = new StringBuilder();
        dfs(len, digits, 0);
        return result;
    }

    private void dfs(int len, String digits, int index) {
        if (path.length() == len) {
            result.add(path.toString());
            return;
        }

        char c = digits.charAt(index);
        String s = letterMap[c - '0'];
        for (int i = 0; i < s.length(); i++) {
            path.append(s.charAt(i));
            dfs(len, digits, index + 1);
            path.deleteCharAt(path.length()-1);
        }
    }

    public static void main(String[] args) {
        letterCombinations letterCombinations = new letterCombinations();
        System.out.println(letterCombinations.letterCombinations("223"));
    }
}
