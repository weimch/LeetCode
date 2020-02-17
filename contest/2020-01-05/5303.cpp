#include <iostream>
#include <sstream>
#include <stack>

using namespace std;

class Solution{
public:
    string freqAlphabets(string s) {
        stack<char> mstack;
        for(int i = s.length() - 1; i >= 0; ){
            char ch = s[i];
            char tmp;
            if(ch == '#'){
                tmp = (s[i - 1] - '0') + (s[i - 2] - '0') * 10 + 'a' - 1;
                i -= 3;
            }else{
                tmp = s[i] - '0' + 'a' - 1;
                i -= 1;
            }
            mstack.push(tmp);
        }
        stringstream ans;
        while(!mstack.empty()){
            ans << mstack.top();
            mstack.pop();
        }
        return ans.str();
    }
};

int main(){
    Solution sol;
    string test1 = "10#11#12";
    string test2 = "1326#";
    string test3 = "25#";
    string test4 = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";
    cout << "test: " << test1 << " -> " << sol.freqAlphabets(test1) << endl;
    cout << "test: " << test2 << " -> " << sol.freqAlphabets(test2) << endl;
    cout << "test: " << test3 << " -> " << sol.freqAlphabets(test3) << endl;
    cout << "test: " << test4 << " -> " << sol.freqAlphabets(test4) << endl;
}