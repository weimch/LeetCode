#include <vector>
#include <iostream>

using namespace std;

class Solution{
public:
    // vector<int> xorQueries(vector<int>& arr, vector<vector<int>>& queries) {
    //     // 暴力求解法，超时
    //     vector<int> ans;
    //     for(int i = 0; i < queries.size(); i ++){
    //         int tmp = 0;
    //         for(int j = queries[i][0]; j <= queries[i][1]; j ++){
    //             tmp ^= arr[j];
    //         }
    //         ans.push_back(tmp);
    //     }
    //     return ans;
    // }
    vector<int> xorQueries(vector<int>& arr, vector<vector<int>>& queries) {
        int *pre = new int[arr.size() + 1];
        pre[0] = 0;
        for(int i = 0; i < arr.size(); i ++){
            pre[i + 1] = pre[i] ^ arr[i];
        }
        vector<int> ans(queries.size());
        for(int i = 0; i < queries.size(); i ++){
            ans[i] = pre[queries[i][0]] ^ pre[queries[i][1] + 1];
        }
        delete [] pre;
        return ans;
    }
};

int main(){
    Solution sol;
    vector<int> arr({1,3,4,8});
    vector<vector<int> > querise({{0, 1}, {1,2}, {0,3}, {3,3}});
    vector<int> result = sol.xorQueries(arr, querise);
    for(int i = 0; i < result.size(); i ++){
        cout << result[i] << ",";
    }
    cout << endl;

    vector<int> arr2({4,8,2,10});
    vector<vector<int> > querise2({{2,3}, {1,3}, {0,0}, {0,3}});
    vector<int> result2 = sol.xorQueries(arr2, querise2);
    for(int i = 0; i < result2.size(); i ++){
        cout << result2[i] << ",";
    }
    cout << endl;
}