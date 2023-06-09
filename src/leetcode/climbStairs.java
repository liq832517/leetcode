package leetcode;

public class climbStairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 2;
        int i=3;
        int temp=0;
        int n1=1,n2=2;
        while (i<n){
            temp=n1;
            n1=n2;
            n2=n2+temp;
            i++;
        }
        return n2;
    }
}

