package mine.leetcode.unique_paths;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sim
 * Date: 2020-12-09
 * Time: 1:43 下午
 */
public class Solution {
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePaths(int m, int n) {
        int[][] path = new int[m][n];
        for (int i = 0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i==0 || j==0){
                    path[i][j] = 1;
                }else {
                    path[i][j] = path[i-1][j] + path[i][j-1];
                }
            }
        }
        return path[m-1][n-1];
    }


    public int uniquePaths2(int m,int n){
        return (int) comb((m+n-2),(n-1));
    }

    public long comb (int a,int b){
        //a 的阶乘
        long aFactorial = factorial(a);
        long bFactorial = factorial(b);
        long abFactorial = factorial(a-b);

        long result = aFactorial/bFactorial/abFactorial;
        return result;
    }

    public long factorial (int x) {
        long result = 1;
        for (int i=1;i<=x;i++){
            result *=i;
        }
        return result;
    }


    public static void main(String[] args) {
        Integer result = new Solution().uniquePaths1(10,10);
        System.out.println(result);
    }
}
