package code;

import java.util.Scanner;
import java.util.Stack;

public class MaxArea {
    public static int largestRectangleArea(int []height) {
        Stack<Integer> s = new Stack<>();
        int max_area = 0; // 最大矩形面积
        int tp; // 栈顶
        int area_with_top;

        int i = 0;
        int n = height.length;
        while (i < n) {
            if (s.empty() || height[s.peek()] <= height[i]) {
                s.push(i++);
            } else {
                tp = s.pop();
                area_with_top = height[tp] * (s.empty() ? i : i - s.peek() - 1);
                max_area = Math.max(max_area, area_with_top);
            }
        }

        while (!s.empty()) {
            tp = s.pop();
            area_with_top = height[tp] * (s.empty() ? i : i - s.peek() - 1);
            max_area = Math.max(max_area, area_with_top);
        }
        return max_area;
    }
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[]a=new int[n];
        for (int i = 0; i <n ; i++) {
           a[i]= scanner.nextInt();
        }
        //int a[]={6,2,5,4,5,1,6};
        System.out.println(largestRectangleArea(a));
    }
}