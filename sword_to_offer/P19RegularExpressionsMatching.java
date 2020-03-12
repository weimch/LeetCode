package sword_to_offer;

/**
 * P19RegularExpressionsMatching
 */
public class P19RegularExpressionsMatching {

    // static public boolean isMatch(String s, String p) {
    //     if(p.length() == 0){
    //         return s.length() == 0;
    //     }
    //     boolean first_match = s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
    //     if(p.length() >= 2 && p.charAt(1) == '*'){
    //         return isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p));
    //     }else{
    //         return first_match && isMatch(s.substring(1), p.substring(1));
    //     }
    // }

    static public boolean isMatch(String s, String p){
        // 使用动态规划来解, dp[i][j]分别是s的前i项和p的前j项匹配, 状态转移方程
        // 如果s[i]==p[j]或者p[j]=='.'，代表当前s[i]和p[j]匹配=> dp[i][j]=dp[i-1][j-1]
        // 如果p[j]=='*'，则分两种情况讨论: 
        //      1) s[i-1]和p[j-1]不匹配=> 直接移除，dp[i][j]=dp[i][j-2]
        //      2) s[i-1]和p[j-1]匹配=> dp[i][j]=dp[i-1][j] OR dp[i][j-2]
        // 其他情况即为False
        if(p.length() == 0){
            return s.length() == 0;
        }
        if(s.length() == 0 && p.length() == 1){
            return false;
        }
        int m = s.length() + 1, n = p.length() + 1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        dp[0][1] = false;
        for(int j = 2; j < n; j ++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-2];
            }
        }
        for(int r = 1; r < m; r ++){
            int i = r - 1;
            for(int c = 1; c < n; c ++){
                int j = c - 1;
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j) == '*'){
                    if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j) == '.'){
                        dp[i][j] = dp[i-1][j] || dp[i][j-2];
                    }else{
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        assert isMatch("a", "ab*");
        assert isMatch("ab", ".*");
        // 仅.匹配到
        // 仅.不能匹配到
        // 仅*匹配到
        // 仅*不能匹配到
        // .*同时存在但不连续
        // .*同时存在但连续
        // 多个.*，同时包含连续和不连续两种情况
    }
}