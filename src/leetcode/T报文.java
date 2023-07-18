package leetcode;

import java.util.ArrayList;
import java.util.List;

public class T报文 {
    private List<String> list = new ArrayList<>();

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            String a = in.nextLine();
        String a = "5a 12 5b ba 34 5b bb 88 88 88 88 88 88 0a 5a";
        List<String> list = new ArrayList<>();

        method1(a, list);
        System.out.print("5a");
        for (String s : list) {
            System.out.print(s);
        }
    }
//    }

    public static void method1(String s, List<String> list) {
        if (s.length() == 0) return;
        if (!s.startsWith("5a")) {
            int inx = s.indexOf("5a");
            method1(s.substring(inx), list);
        }

        int rear = s.indexOf("5a", 2);
        String tmp = s.substring(0, rear + 2);
        int count = 0;
        int idx = 0;
        while (s.indexOf("5b ba", idx) != -1) {
            idx = s.indexOf("5b ba", idx + 5);
            if (idx == -1) break;
            count++;
        }
        idx = 0;
        while (s.indexOf("5b bb", idx) != -1) {

            idx = s.indexOf("5b bb", idx + 5);
            if (idx == -1) break;
            count++;
        }

        String[] arrays = tmp.split(" ");
        for (int a = 0; a < arrays.length; a++) {
            if (arrays[a].length()==1){
                tmp=tmp.replace(" "+arrays[a]+" "," 0"+arrays[a]+" ");
            }
        }
        if (arrays.length<3) return;

        if (count + Integer.parseInt(arrays[arrays.length - 2]) == arrays.length - 3) {
            list.add(tmp.substring(2));
        }


        int newIdx = s.indexOf("5a", rear + 3);
        if (newIdx == -1) return;
        String newStr = s.substring(newIdx);

        method1(newStr, list);
    }
}