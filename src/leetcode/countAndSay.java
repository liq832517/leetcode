package leetcode;

import java.util.HashMap;
import java.util.Map;

public class countAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
    public static String countAndSay(int n) {
        if (n==1) return "1";
        String s=method("1");
        for (int i = 1; i < n-1; i++){
            s=method(s);
        }
        return s;
    }
    private static String method(String str){
        if (str.equals("1")) return "11";
        char[]chars=str.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        StringBuilder res= new StringBuilder();
        int i=0,j=1;
        while (j<chars.length){
            if (chars[i]==chars[j]){
                j++;
            }
            else {
                res.append(j - i).append(chars[i]);
                i=j;
            }
        }
        res.append(j - i).append(chars[i]);
        return res.toString();

    }
}
