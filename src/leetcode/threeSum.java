package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            if (nums[left] < 0 && nums[i] < Integer.MIN_VALUE - nums[left]) continue;
            if (nums[i] > 0 && nums[i] > Integer.MAX_VALUE - nums[left]) break;
            while (left < right) {
                if (nums[left] + nums[i] > -nums[right]) {
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    right--;
                } else if (nums[left] + nums[i] < -nums[right]) {
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    right--;
                    left++;
                }
            }

        }
        return res;
    }
}
