package code;

public class 数组中的逆序对 {
    public static int InversePairs(int [] array) {
        if(array.length<2)return 0;
        int cur=1,res=0,count=0;
        while (res<array.length-1){
            if(array[res]>array[cur]){count++;}
            if(cur<array.length-1)cur++;
            else {
                res++;
                cur=res+1;
            }
        }
        return count;
    }
    public static void main(String[]args){
        System.out.println(InversePairs(new int[]{1,2,3,4,5,6,7,0}) );
    }
}
