#include <iostream>
#include <vector>

using namespace std;

class Solution{
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int mid1 = (nums1.size() + nums2.size()) / 2;
        bool even_size = (nums1.size() + nums2.size()) % 2 == 0;
        int i, j, count = 0;
        for(i = 0, j = 0; i < nums1.size(), j < nums2.size(); ){
            if(nums1[i] < nums2[j]){
                i ++;
            }else{
                j ++;
            }
            count += 1;
        }
    }
};

int main(){
    Solution sol;
    vector<int> nums1({1,3});
    vector<int> nums2({2});
    cout << sol.findMedianSortedArrays(nums1, nums2) << endl;
}