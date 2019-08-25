package code;

public class 丑数 {

    public static int GetUglyNumber_Solution(int index) {
        if(index==1)
            return 1;
        if (index<1)
        return 0;
        int []res=new int[index];
        res[0]=1;
        int t2=0,t3=0,t5=0;
        for (int j = 1; j <index ; j++) {
            res[j]=Math.min(Math.min(res[t2]*2,res[t3]*3),res[t5]*5);
            if(res[j]==res[t2]*2)t2++;
            if(res[j]==res[t3]*3)t3++;
            if(res[j]==res[t5]*5)t5++;
        }
        return res[index-1];
    }
    public static void main(String[]args){
        System.out.println(GetUglyNumber_Solution(100));
    }
}
