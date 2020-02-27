#include <iostream>
#include <ctype.h>

using namespace std;

class Solution {
public:
    string longestPalindrome(string s) {
        if(s == ""){
            return "";
        }
        static bool dp[1010][1010];
        // use dynamic programing to solve this problem
        int len = s.size(), li = 0, ls = 1;
        // initialize base
        for(int i = 0; i < len; i ++){
            dp[i][i] = true;
            dp[i][i+1] = s[i] == s[i+1];
            if(dp[i][i+1] && ls < 2){
                ls = 2;
                li = i;
            }
        }
        // dynamic programing, from right down coner to left up coner
        for(int i = len - 2; i >=0; i --){
            for(int j = i + 2; j < len; j ++){
                dp[i][j] = dp[i+1][j-1] && s[i] == s[j];
                if(dp[i][j] && ls < j - i + 1){
                    ls = j - i + 1;
                    li = i;
                }
            }
        }
        return s.substr(li, ls);
    }
};

int main(){
    Solution sol;
    cout << sol.longestPalindrome("a") << endl;
    cout << sol.longestPalindrome("babad") << endl;
    cout << sol.longestPalindrome("cbbd") << endl;
}