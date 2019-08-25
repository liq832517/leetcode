package leetcode;

public class 最后一个单词的长度 {
    public int lengthOfLastWord(String s) {
        String[]strings=s.split(" ");
        int len=strings.length;
        if(strings.length==0)
           return -1;

        String res=strings[len-1];
        return res.length();
    }
}
