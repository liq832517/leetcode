package code;

public class 连续子数组最大和 {
    public static void main(String[] args){
        int x=FindGreatestSumOfSubArray(new int[]{111,-2,-3,-3,-4,-6,115});
        System.out.println(x);
    }
    public static int FindGreatestSumOfSubArray(int[] array) {

        if(array.length==0||array==null)
            return 0;
        int res=0;
        int max=0;
        for (int i = 0; i <array.length ; i++) {
            max=Math.max(max+array[i],array[i]);
            res=Math.max(max,res);
        }
        return res;
    }
}
