package leetcode;

import java.util.Arrays;

public class threeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        int left, right, mid;
        int sum;
        for (left = 0; left < nums.length - 2; left++) {
            mid = left = 1;
            right = nums.length - 1;
            while (mid != right) {
                sum = nums[left] + nums[mid] + nums[right];
                if (Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    mid++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        threeSumClosest(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2);
    }
}
