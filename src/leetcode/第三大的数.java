package leetcode;

import org.junit.Test;

import java.util.PriorityQueue;

public class 第三大的数 {
    @Test
    public void test() {
        System.out.println(thirdMax(new int[]{3,2,1}));
    }

    public int thirdMax(int[] nums) {

        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int flag = 0;//判断有多少个不重复的数
        boolean isMin_VALUE = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MIN_VALUE && isMin_VALUE) {
                flag++;
                isMin_VALUE = false;
            }
            if (nums[i] > max1) {
                flag++;
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2 && nums[i] < max1) {
                flag++;
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3 && nums[i] < max2) {
                flag++;
                max3 = nums[i];
            }
        }
        return flag >=3 ? max3 : max1;
    }
}
