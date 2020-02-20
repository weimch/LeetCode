#include <iostream>
#include <vector>
#include <assert.h>

using namespace std;

class Solution {
public:
    string convert(string s, int numRows) {
        if(numRows == 1){
            return s;
        }
        int minRows = min(numRows, (int)s.size());
        char direction = 'v'; // 'v' for going down '^' for going up
        vector<string> rows(minRows);
        for(int i = 0, idx = 0; i < s.size(); i ++){
            if(direction == 'v'){
                rows[idx] += s[i];
                idx += 1;
                if(idx == numRows){
                    idx = idx - 2;
                    direction = '^';
                }
            }else{
                rows[idx] += s[i];
                if(idx == 0){
                    direction = 'v';
                    idx += 1;
                    continue;
                }
                idx -= 1;
            }
        }
        string res = "";
        for(string row : rows){
            res += row;
        }
        return res;
    }
};

int main(){
    Solution sol;
    assert(sol.convert("ABCD", 2) == "ACBD");
    assert(sol.convert("PAYPALISHIRING", 3) == "PAHNAPLSIIGYIR");
    assert(sol.convert("PAYPALISHIRING", 4) == "PINALSIGYAHRPI");
}

