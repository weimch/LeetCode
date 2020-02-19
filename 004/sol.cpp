#include <iostream>
#include <vector>

using namespace std;

class Solution{
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int mid1 = (nums1.size() + nums2.size()) / 2;
        bool is_even = (nums1.size() + nums2.size()) % 2 == 0;
        int i, j, counter = 0, s1;
        for(i = 0, j = 0; i < nums1.size() && j < nums2.size(); ){
            int select;
            if(nums1[i] < nums2[j]){
                select = nums1[i];
                i ++;
            }else{
                select = nums2[j];
                j ++;
            }
            if(is_even && counter == mid1 - 1){
                s1 = select;
            }else if(is_even && counter == mid1){
                return (s1 + select) / 2.0;
            }else if(!is_even && counter == mid1){
                return select;
            }
            counter ++;
        }
        while(i < nums1.size()){
            int select = nums1[i];
            if(is_even && counter == mid1 - 1){
                s1 = select;
            }else if(is_even && counter == mid1){
                return (s1 + select) / 2.0;
            }else if(!is_even && counter == mid1){
                return select;
            }
            i ++;
            counter ++;
        }
        while(j < nums2.size()){
            int select = nums2[j];
            if(is_even && counter == mid1 - 1){
                s1 = select;
            }else if(is_even && counter == mid1){
                return (s1 + select) / 2.0;
            }else if(!is_even && counter == mid1){
                return select;
            }
            j ++;
            counter ++;
        }
        return 0.0;
    }
};

int main(){
    Solution sol;
    vector<int> nums1({1,2});
    vector<int> nums2({3,4});
    cout << sol.findMedianSortedArrays(nums1, nums2) << endl;
}