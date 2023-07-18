package leetcode;

import java.util.Scanner;

public class 字符串加减法 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String a = in.nextLine();
            int num=0;
            String[]plus=a.split("\\+");
            for(String s:plus){
                if(!s.contains("-")){
                    num+=Integer.parseInt(s);
                }

                else if(s.startsWith("-")){
                    String[]temp=s.split("-");
                    for(int i=1;i<temp.length;i++){
                        num-=Integer.parseInt(temp[i]);
                    }
                } else{
                    String[]temp=s.split("-");
                    num+=Integer.parseInt(temp[0]);
                    for(int i=1;i<temp.length;i++){
                        num-=Integer.parseInt(temp[i]);
                    }
                }
            }
            System.out.println(num);
        }
    }
}