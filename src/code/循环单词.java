package code;

import java.util.ArrayList;
import java.util.List;

public class 循环单词 {
    public static int countRotateWords(List<String> words) {

        if(words.size()<=1)
            return words.size();
        for (int i = 0,j=1; i <words.size()-1 ; ) {
            if(j>=words.size()){
                i++;j=i+1;continue;
            }
            if(IsRotate(words.get(i),words.get(j)))
                words.remove(j);
            else j++;
        }
        return words.size();
    }
    private static boolean IsRotate(String s1,String s2){
        if(s1.length()!=s2.length())
            return false;
        char[]c1=s1.toCharArray();
        char[]c2=s2.toCharArray();
        int i= 0;
        while (s1.charAt(i)!=s2.charAt(i)) {
            i++;
            if(i==s1.length()){
                i--;break;
            }

        }
        String temp=s1.substring(i);
        s1=temp+s1.substring(0,i);
        if(s1.equals(s2))
            return true;

        return false;
    }
    public static void main(String[]args){

        List<String>words=new ArrayList<>();
        String[]c=new String[]{"abba", "abab", "baba", "abab", "baba", "bbaa", "aabb"};
        for (String s:c
             ) {
            words.add(s);
        }

        //System.out.println("abba".indexOf(1));
        System.out.println(countRotateWords(words));
    }
}
