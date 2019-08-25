package code;

public class 爱奇艺面试 {
    public static void main(String[]args){
        int[]n=new int[26];
        String s1="act";
        String s2="ctn";

        char[]c1=s1.toCharArray();
        char[]c2=s2.toCharArray();
        for (int i = 0; i <c1.length ; i++) {
            n[c1[i]-'a']++;
            n[c2[i]-'a']--;
        }
        for (int i = 0; i <c1.length ; i++) {
            if(n[i]!=0) {
                System.out.println(false);
                System.exit(0);
            }
        }
        System.out.println(true);

    }
}
