package leetcode;

import org.junit.Test;

public class findKthLargest {
    @Test
    public void test() {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        int low = 0, high = nums.length - 1, mid = 0;
        while (low <= high) {
            mid = quickSort(nums, low, high);
            if (mid == k - 1) return nums[mid];
            else if (mid > k - 1) high = mid - 1;
            else low = mid + 1;
        }

        return -1;
    }

    static int quickSort(int[] nums, int low, int high) {
        int i = low, j = high;
        int temp = nums[low];
        while (i < j) {
            while (i < j && nums[j] < temp) j--;
            while (i < j && nums[i] >= temp) i++;
            if (i < j) {
                swap(nums, i, j);
            }
        }
        if (i != low) {
            swap(nums, i, low);
        }
        return i;
    }

    static void swap(int nums[], int x, int y) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }
}
