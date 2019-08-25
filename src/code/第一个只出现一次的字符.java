package code;

/*在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置*/
public class 第一个只出现一次的字符 {
    public static int FirstNotRepeatingChar(String str) {
        if(str.length()==0)
            return -1;
        int cur,res;
        char[]a= str.toCharArray();
        res=cur=0;
        while (cur<str.length()){
            if(a[cur]==a[res]&&cur!=res){
                res++;cur=0;
            }
            else
                cur++;
        }
        return str.indexOf(a[res]);
    }
    public static void main(String[]args){
        String s="qaCkq";
        System.out.println( FirstNotRepeatingChar(s));
    }
}
