package leetcode;

public class 尾部的零 {
    public long trailingZeros(long n) {

        long count=5;
        long sum=0;

        while (count*5<n){
            sum+=n/count;
            count*=5;
        }
        return sum;
    }
}
