package leetcode;

import org.junit.Test;

public class maxArea {
    @Test
    public void test() {
        System.out.println(maxArea(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
    }

    public int maxArea(int[] height) {

        int left = 0, right = height.length - 1, sum = 0;
        while (left < right) {
            sum = Math.max(sum, (right - left) * Math.min(height[right], height[left]));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return sum;
    }
}
