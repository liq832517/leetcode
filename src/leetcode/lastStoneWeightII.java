package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class lastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int target = sum / 2;

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int s : stones) {
            for (int j = target; j >= s; j--) {
                if (dp[j] == 1) {
                    continue;
                }
                dp[j] = Math.max(dp[j], dp[j - s] + s);
            }
        }


        return sum - dp[target] * 2;
    }

}
