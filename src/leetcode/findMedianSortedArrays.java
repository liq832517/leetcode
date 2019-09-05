package leetcode;

import org.junit.Test;

public class findMedianSortedArrays {
    @Test
    public void test() {
        System.out.println(findMedianSortedArrays(new int[]{1, 2, 3, 4}, new int[]{2, 4, 6}));
        System.out.println(findMedianSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6}));
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int t = m;
            m = n;
            n = t;
        }

        int iMin = 0, iMax = m, mid = (m + n + 1) / 2;

        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = mid - i;
            if (i < iMax && nums1[i] < nums2[j - 1]) {
                iMin = i + 1;
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) return maxLeft;
                int minRight = 0;

                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
