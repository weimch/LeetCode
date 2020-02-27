#include <iostream>
#include <cassert>

using namespace std;

class Solution {
public:
    bool isMatch(string s, string p) {
        
    }
};

int main(){
    Solution sol;
    assert(!sol.isMatch("aa", "a"));
    assert(sol.isMatch("aa", "a*"));
    assert(sol.isMatch("ab", ".*"));
    assert(sol.isMatch("aab", "c*a*b"));
    assert(!sol.isMatch("mississippi", "mis*is*p*."));
}