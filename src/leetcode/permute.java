package leetcode;

import java.util.ArrayList;
import java.util.List;

public class permute {
    private List<List<Integer>> res;
    private List<Integer> path;
    private int[] visited;

    public List<List<Integer>> permute(int[] nums) {

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
            visited[k] = 1;
            path.add(nums[k]);
            backtrack(nums, len);
            visited[k] = 0;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        permute permute=new permute();
        System.out.println(permute.permute(new int[]{1, 2, 3}));
    }
}
