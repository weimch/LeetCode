#include <iostream>
#include <cassert>

using namespace std;

class Solution {
public:
    int reverse(int x) {
        long long res = 0;
        while(x != 0){
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (res > INT32_MAX || res < INT32_MIN) ? 0 : res;
    }
};

int main(){
    Solution sol;
    assert(sol.reverse(-2147483412) == -2143847412);
    assert(sol.reverse(1534236469) == 0);
    assert(sol.reverse(123) == 321);
    assert(sol.reverse(-123) == -321);
    assert(sol.reverse(120) == 21);
}