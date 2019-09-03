package leetcode;

import org.junit.Test;

import java.util.Stack;

public class decodeString {
    @Test
    public void test() {
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }

    public String decodeString(String s) {

        Stack<Integer> count = new Stack<Integer>();
        Stack<String> string = new Stack<String>();
        String res = "";
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                count.push(num);
            } else if (s.charAt(i) == '[') {
                string.push(res);
                res = "";
                i++;
            } else if (Character.isLetter(s.charAt(i))) {
                res += s.charAt(i++);
            } else if (s.charAt(i) == ']') {
                String temp = string.pop();//栈里放着的是前缀，循环体在res中
                int n = count.pop();
                for (int k = 0; k < n; k++) {
                    temp += res;
                }
                res = temp;
                i++;
            }
        }

        return res;
    }
}
