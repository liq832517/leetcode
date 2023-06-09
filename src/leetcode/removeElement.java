package leetcode;

public class removeElement {
    public static int removeElement(int[] nums, int val) {
        int i=0,j=nums.length-1;
        while (i<=j) {
            if (nums[i]!=val){
                i++;
            }else {
                swap(i,j,nums);
                j--;
            }
        }
        return j+1;

    }
    private static void swap(int i,int j, int[] num){
        int temp=num[i];
        num[i]=num[j];
        num[j]=temp;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3,2,2,3}, 3));
    }
}
