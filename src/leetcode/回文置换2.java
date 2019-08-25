package leetcode;

import java.util.LinkedList;
import java.util.List;

//917. Palindrome Permutation II
public class 回文置换2 {
    public static void main(String[]args){
        String s="aabb";

        for (String str:generatePalindromes(s)
             ) {
            System.out.println(str);
        }
    }
    public static List<String> generatePalindromes(String s) {
        List<String> res=new LinkedList<>();
        int []letter=new int[26];

        char[]c=s.toCharArray();
        for (int i = 0; i <c.length ; i++) {
            letter[c[i]-'a']++;
        }
        int count=0;
        for (int i = 0; i < letter.length; i++) {
            if(letter[i]%2!=0)
                count++;
        }
        if(count>1)return res;
        else if(count==1){

        }
        return res;
    }
}
