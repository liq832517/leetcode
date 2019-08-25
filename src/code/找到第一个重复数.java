package code;
//时间复杂度O(n)空间复杂度O（1)
public class 找到第一个重复数 {
    public static boolean duplicate(int numbers[],int length,int [] duplication) {

        int temp=0;
        for (int i = 0; i <length ; i++) {
            temp=numbers[i];
            if(temp>length)
                temp-=length;

            if (numbers[temp]>=length){
                duplication[0]=temp;
                System.out.println(duplication[0]);
                return true;
            }

            numbers[temp]+=length;


        }
        duplication[0]=-1;
        return false;
    }
    public static void main(String[]args){
        duplicate(new int[]{2,1,3,0,4},5,new int[1]);
    }
}
