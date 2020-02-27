#include <iostream>
#include <string>
#include <cassert>

using namespace std;

class Solution {
public:
    int myAtoi(string str) {
        // 1) strip str left
        int l_idx, r_idx;
        for(l_idx = 0; l_idx < str.length(); l_idx ++){
            if(str[l_idx] != ' '){
                break;
            }
        }
        if(l_idx == str.length()){
            // no string to be parse
            return 0;
        }
        bool is_negative = false;
        if(str[l_idx] == '-'){
            is_negative = true;
            l_idx ++;
        }else if(str[l_idx] == '+'){
            l_idx ++;
        }
        long long res = 0;
        for(; l_idx < str.length(); l_idx ++){
            if(isdigit(str[l_idx]) == 0){
                break;
            }
            res = res * 10 + str[l_idx] - '0';
            if(res > INT32_MAX){
                if(is_negative){
                    return INT_MIN;
                }else{
                    return INT_MAX;
                }
            }
        }
        return is_negative ? -res : res;
    }
};

int main(){
    Solution sol;
    assert(sol.myAtoi("   -42") == -42);
    assert(sol.myAtoi("42") == 42);
    assert(sol.myAtoi("words and 987") == 0);
    assert(sol.myAtoi("4193 with words") == 4193);
    assert(sol.myAtoi("-91283472332") == INT_MIN);
}