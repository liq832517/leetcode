package leetcode;

import java.util.Arrays;

public class intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);


        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] result = new int[len1];


        int i = 0, j = 0, cur = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] == nums2[j]) {
                result[cur] = nums2[j];
                i++;
                j++;
                cur++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOfRange(result, 0,cur);
    }

    public static void main(String[] args) {
         intersect intersect=new intersect();
        System.out.println(Arrays.toString(intersect.intersect(new int[]{1, 1, 2, 2}, new int[]{2, 2})));
    }
}
