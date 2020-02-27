#include <iostream>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL){}
};

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int carry = 0;
        ListNode *rl = NULL, *crl = NULL;
        while(l1 != NULL && l2 != NULL){
            int val = l1->val + l2->val + carry;
            carry = val / 10;
            if(crl == NULL){
                // init
                crl = new ListNode(val % 10);
                rl = crl;
            }else{
                crl->next = new ListNode(val % 10);
                crl = crl->next;
            }
            l1 = l1->next;
            l2 = l2->next;
        }
        while(l1 != NULL){
            int val = l1->val + carry;
            carry = val / 10;
            crl->next = new ListNode(val % 10);
            crl = crl->next;
            l1 = l1->next;
        }
        while(l2 != NULL){
            int val = l2->val + carry;
            carry = val / 10;
            crl->next = new ListNode(val % 10);
            crl = crl->next;
            l2 = l2->next;
        }
        if(carry){
            crl->next = new ListNode(1);
        }
        return rl;
    }
};

int main(){
    Solution sol;
    // Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    // Output: 7 -> 0 -> 8
    // Explanation: 342 + 465 = 807.
    ListNode *l1 = new ListNode(3);
    l1->next = new ListNode(7);
    ListNode *l2 = new ListNode(9);
    l2->next = new ListNode(2);
    // l2->next->next = new ListNode(4);
    ListNode *rl = sol.addTwoNumbers(l1, l2);
    while(rl != NULL){
        cout << rl->val;
        rl = rl->next;
    }
    cout << endl;
    return 0;
}
