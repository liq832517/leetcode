package code;

public class 数组中出现次数超过一半的数字 {
    public static int MoreThanHalfNum_Solution(int [] array) {
        int n=array.length;
        int compare=(n+1)/2;
        int count=1;
        int soldier=array[1];
        for (int i = 1; i <n ; i++) {
            if(soldier==array[i]){
                count++;continue;
            }else if(soldier!=array[i]&&count>0){
                count--;continue;
            }else {
                soldier=array[i];
                count=1;
            }
        }
        count=0;
        for (int i = 0; i < n; i++) {
            if(array[i]==soldier)
                count++;
        }
        return count>=compare?soldier:0;
    }
    public static void main(String[]a){
       System.out.println(MoreThanHalfNum_Solution(new int[]{1,2,3,4,4,4,4,4,5}));
    }
}
