package leetcode;


import java.util.Arrays;

public class multiply {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0"))return "0";
        char[] num1array = num1.toCharArray();
        char[] num2array = num2.toCharArray();
        int[] multiplyRes = new int[num1array.length + num2array.length];
        for (int i = 0; i < num1array.length; i++) {
            for (int j = 0; j < num2array.length; j++) {
                multiplyRes[i + j+1] += (num1array[i] - '0') * (num2array[j] - '0');
            }
        }

        for (int i = multiplyRes.length - 1; i >= 0; i--) {
            if (multiplyRes[i] > 9) {
                multiplyRes[i - 1] += multiplyRes[i] / 10;
                multiplyRes[i] = multiplyRes[i] % 10;
            }
        }

        StringBuilder res = new StringBuilder();
        if (multiplyRes[0]!=0){
            res.append(multiplyRes[0]);
        }
        for (int i = 1; i < multiplyRes.length; i++) {
            res.append(multiplyRes[i]);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        multiply multiply = new multiply();
        System.out.println(multiply.multiply("111", "222"));
    }
}
