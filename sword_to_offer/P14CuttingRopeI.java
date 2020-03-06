package sword_to_offer;

/**
 * P14CuttingRopeI
 */
public class P14CuttingRopeI {

    public int cuttingRope(int n) {
        if(n < 1) return 0;
        if(n == 2) return 1;
        if(n == 3) return 2;
        // 使用动态规划解决问题 f(n)=max(f(n-i)*f(i)), i取值范围是1~n-1，复杂度是O(n^2)
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i <= n; i ++){
            dp[i] = Integer.MIN_VALUE;
            for(int j = 1; j < i; j ++){
                dp[i] = Math.max(dp[i], dp[i-j] * dp[j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        P14CuttingRopeI sol = new P14CuttingRopeI();
        assert sol.cuttingRope(2) == 1;
        assert sol.cuttingRope(8) == 18;
        assert sol.cuttingRope(10) == 36;
    }
}