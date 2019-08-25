package code;

public class 正则表达式匹配 {
    public static boolean match(char[] str, char[] pattern)
    {
        if (str==null||pattern==null)
            return false;
        int strIndex=0;
        int patternIndex=0;
        return matchCore(str,pattern,strIndex,patternIndex);
    }
    private static boolean matchCore(char[]str,char[] pattern,int strIndex,int patternIndex){
        if (str.length==strIndex&&pattern.length==patternIndex)
        return true;
        if (str.length!=strIndex&&pattern.length==patternIndex)
            return false;
        if (patternIndex+1<pattern.length&&pattern[patternIndex+1]=='*'){
            if ((str.length!=strIndex&&str[strIndex]==pattern[patternIndex])||(str.length!=strIndex&&pattern[patternIndex]=='.')){
                return matchCore(str,pattern,strIndex,patternIndex+2)||
                        matchCore(str,pattern,strIndex+1,patternIndex+2)||
                        matchCore(str,pattern,strIndex+1,patternIndex);
            }
            else
                return  matchCore(str,pattern,strIndex,patternIndex+2);
        }

        if((str.length!=strIndex&&str[strIndex]==pattern[patternIndex])||(str.length!=strIndex&&pattern[patternIndex]=='.')){
            return matchCore(str,pattern,strIndex+1,patternIndex+1);
        }
        return false;
    }
    public static void main(String[]args){
        System.out.println(match(new char[]{},new char[]{'.','*'}));
    }
}
