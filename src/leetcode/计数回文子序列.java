package leetcode;
/*我们再来看一种迭代的写法，使用一个二维的dp数组，其中dp[i][j]表示子字符串[i, j]中的不同回文子序列的个数，
我们初始化dp[i][i]为1，因为任意一个单个字符就是一个回文子序列，其余均为0。这里的更新顺序不是正向，也不是逆向，而是斜着更新*/
public class 计数回文子序列 {
    public static int countPalindSubseq(String str) {
        if(str.length()==0)
            return 0;
        int n=str.length();
        char[] c=str.toCharArray();
        int [][]dp=new int[n][n];
        for (int i = 0; i <n ; i++) {
            dp[i][i]=1;
        }
        int m=1000000007;
        for (int len = 1; len <n ; len++) {
            for (int i = 0; i <n-len ; i++) {
                int j=i+len;
                if(c[i]==c[j]){
                    dp[i][j]=dp[i+1][j-1]*2;
                    int l=i+1;
                    int r=j-1;
                    while (l<=r&&c[l]!=c[i])l++;
                    while (l<=r&&c[r]!=c[i])r--;
                    if(l==r){
                        dp[i][j]+=1;
                    }else if (l<r){
                        dp[i][j]-=dp[l+1][r-1];
                    }else {
                        dp[i][j]+=2;
                    }
                }else {
                    dp[i][j]=dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
                }
                dp[i][j] = (dp[i][j] < 0) ? dp[i][j] + m : dp[i][j] % m;
            }
        }
        return dp[0][n-1];
    }
    public static void main(String[] args){
     int x=countPalindSubseq("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba");
        System.out.println(x);}
}
