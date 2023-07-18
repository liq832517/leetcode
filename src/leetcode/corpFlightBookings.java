package leetcode;

import java.util.Arrays;

public class corpFlightBookings {

    public static void main(String[] args) {
        corpFlightBookings corpFlightBookings = new corpFlightBookings();
        int[][] init = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        System.out.println(Arrays.toString(corpFlightBookings.corpFlightBookings(init, 5)));
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];

        for (int[] booking : bookings) {
            ans[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                ans[booking[1]] -= booking[2];
            }
        }

        for (int i = 1; i < n; i++) {
            ans[i] += ans[i - 1];
        }
        return ans;
    }
}
