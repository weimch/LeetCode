#include <iostream>
#include <vector>
#include <map>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result(2);
        map<int, int> kv;
        for(unsigned int i = 0; i < nums.size(); i ++){
            int other = target - nums[i];
            if(kv.find(other) != kv.end()){
                result[0] = kv[other];
                result[1] = i;
                return result;
            }
            kv[nums[i]] = i;
        }
        return result;
    }
};

int main(){
    Solution sol;
    vector<int> nums({2, 7, 11, 15});
    vector<int> result = sol.twoSum(nums, 9);
    cout << "Pos at: (" << result[0] << "," << result[1] << ")" << endl;
    result = sol.twoSum(nums, 22);
    cout << "Pos at: (" << result[0] << "," << result[1] << ")" << endl;
    return 0;
}
