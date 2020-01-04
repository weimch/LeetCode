#include <iostream>
#include <map>

using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int ans = 0, i, j;
        map<char, int> idx_map;
        for(i = 0, j = 0; j < s.length(); j ++){
            if(idx_map.find(s[j]) != idx_map.end()){
                ans = max(ans, j - i);
                i = max(idx_map[s[j]] + 1, i);
            }
            idx_map[s[j]] = j;
        }
        ans = max(ans, j - i);
        return ans;
    }
};

int main(){
    Solution sol;
    cout << "tests: abcabcbb -> " << sol.lengthOfLongestSubstring("abcabcbb") << endl;
    cout << "tests: bbbbb -> " << sol.lengthOfLongestSubstring("bbbbb") << endl;
    cout << "tests: pwwkew -> " << sol.lengthOfLongestSubstring("pwwkew") << endl;
    cout << "tests: blank -> " << sol.lengthOfLongestSubstring(" ") << endl;
    cout << "tests: au -> " << sol.lengthOfLongestSubstring("au") << endl;
    cout << "tests: abba -> " << sol.lengthOfLongestSubstring("abba") << endl;
    return 0;
}
