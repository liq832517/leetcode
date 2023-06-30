package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permuteUnique {
    private List<List<Integer>> res;
    private List<Integer> path;
    private int[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        res = new ArrayList<>();
        path = new ArrayList<>();
        int len = nums.length;
        visited = new int[len];

        backtrack(nums, len);
        return res;
    }

    private void backtrack(int[] nums, int len) {
        if (path.size() == len) {
            res.add(new ArrayList<>(path));
        }
        for (int k = 0; k < len; k++) {

            if (visited[k] == 1) continue;
            if (k > 0 && nums[k] == nums[k-1] && visited[k-1] == 0){
                continue;
            }

            visited[k] = 1;
            path.add(nums[k]);
            backtrack(nums, len);
            visited[k] = 0;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        permuteUnique permute=new permuteUnique();
        System.out.println(permute.permuteUnique(new int[]{1, 1, 2}));
    }
}
