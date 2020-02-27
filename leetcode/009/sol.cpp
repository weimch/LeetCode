#include <iostream>
#include <cassert>
#include <cstring>
using namespace std;

class Solution {
public:
    bool isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        static char s[11];
        int s_len = 0;
        while(x > 0){
            s[s_len++] = x % 10;
            x /= 10;
        }
        for(int i = 0; i < s_len / 2; i ++){
            if(s[i] != s[s_len-1-i]){
                return false;
            }
        }
        return true;
    }
};

int main(){
    Solution sol;
    assert(sol.isPalindrome(1001));
    assert(sol.isPalindrome(121));
    assert(!sol.isPalindrome(-121));
    assert(!sol.isPalindrome(10));
}