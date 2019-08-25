package code;

import java.util.Scanner;

public class 数字字符 {
    public static void main(String[]args){
        int[]vist=new int[10];
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        if(s.length()>1000||s.length()<1)
            System.exit(0);
        for (int i = 0; i <s.length() ; i++) {
            int temp=Integer.parseInt(s.charAt(i)+"");
            vist[temp]+=1;
        }
        String ans="";
        if(vist[1]==0){
            ans="1";
        }else {
            for (int i = 2; i <10 ; i++) {
                if(vist[i]==0){
                    ans=""+i;
                    break;
                }
            }
        }
        if(ans.equals("")){
            if(vist[0]==0)
                ans="10";
            else {
                int min=vist[1];
                int idx=1;
                for (int i = 2; i <10 ; i++) {
                    if(min>vist[i]){
                        min=vist[i];
                        idx=i;
                    }
                }
                ans=""+idx;
                while (min>0){
                    min--;
                    ans+=""+idx;
                }
            }
        }

        System.out.print(ans);
    }
}
