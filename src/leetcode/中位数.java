package leetcode;

import java.util.Arrays;

public class 中位数 {
    public int median(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        return nums[(nums.length-1)/2];
    }
}
