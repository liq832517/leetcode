package leetcode;

import java.util.Iterator;
import java.util.List;

public class MeetingRoom2 {

    class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int minMeetingRooms(List<Interval> intervals) {
        int max=0;
        for (Interval i:intervals
             ) {
            max=Math.max(max,i.end);
        }
        int timePoint[]=new int[max+1];
        for (Interval i:intervals
             ) {
            timePoint[i.start]++;
            timePoint[i.end]--;
        }
        int sum=0,res=Integer.MIN_VALUE;
        for (int i:timePoint
             ) {
            sum+=i;
            res=Math.max(res,sum);
        }

        return res;
    }
}
