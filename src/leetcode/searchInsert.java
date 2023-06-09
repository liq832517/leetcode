package leetcode;

public class searchInsert {
    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || nums[0] >= target) return 0;
        if (nums[nums.length - 1] < target) return nums.length;
        int i = 0, j = nums.length - 1;
        int mid;

        while (i <= j) {
            mid=(i+j)/2;
            if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3}, 2));
    }
}
