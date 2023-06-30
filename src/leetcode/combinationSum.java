package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class combinationSum {
    private List<List<Integer>> res;
    private Deque<Integer> path;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        int len = candidates.length;
        if (len == 0) {
            return res;
        }
        // 排序是剪枝的前提
        Arrays.sort(candidates);
        path = new ArrayDeque<>();
        dfs(candidates, len, 0, target);

        return res;
    }

    private void dfs(int[] candidates, int len, int begin, int target) {
        if (target == 0) {
            List<Integer> list = new ArrayList<>(path);
//                if (!res.contains(list))
            res.add(list);
            return;
        }
        for (int i = begin; i < len; i++) {

            if (target < candidates[i]) {
                break;
            }
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            dfs(candidates, len, i+1, target - candidates[i]);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        combinationSum combinationSum=new combinationSum();
        combinationSum.combinationSum(new int[]{1,2,7,6,1,5,8},8).forEach(System.out::println);
    }
}
