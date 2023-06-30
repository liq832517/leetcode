package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class nextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,2, 1};
        nextPermutation nextPermutation = new nextPermutation();
        nextPermutation.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num);
        }

    }

    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int i = nums.length - 2;
        //找到第一个不是降序的index
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        //将它和后面最后一个比它大的互换
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(i, j, nums);
        }
        //将后面的数字生序排列
        ascend(i + 1, nums);
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void ascend(int i, int[] nums) {
        Arrays.sort(nums, i,nums.length);
    }
}
