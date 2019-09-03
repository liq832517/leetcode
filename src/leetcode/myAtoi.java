package leetcode;

import org.junit.Test;

public class myAtoi {
    @Test
    public void test() {
        System.out.println(myAtoi("-2147483649"));
    }

    public int myAtoi(String str) {

        int res = 0;
        int flag = 1;
        str = str.trim();
        if (str.equals("") || ('-' != str.charAt(0) && '+' != str.charAt(0) && !Character.isDigit(str.charAt(0)))) {
            return 0;
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+' && i == 0) {
                continue;
            }
            if (str.charAt(i) == '-' && i == 0) {
                flag = -1;
                continue;
            }
            if (!Character.isDigit(str.charAt(i))) {
                break;
            }
            if (res * flag > Integer.MAX_VALUE / 10 || res * flag == Integer.MAX_VALUE / 10 && (str.charAt(i) - '0') > 7) {
                return Integer.MAX_VALUE;
            }
            if (res * flag < Integer.MIN_VALUE / 10 || res * flag == Integer.MIN_VALUE / 10 && flag*(str.charAt(i) - '0') < -8) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + (str.charAt(i) - '0');

        }
        return res * flag;
    }
}
