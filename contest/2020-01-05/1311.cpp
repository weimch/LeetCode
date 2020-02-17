#include <iostream>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

class Solution{
public:
    vector<string> watchedVideosByFriends(vector<vector<string>>& watchedVideos, vector<vector<int>>& friends, int id, int level) {
        vector<int> level_friend = friends[id];
        vector<bool> visited(friends.size(), false);
        visited[id] = true;
        int lv_count = 1;
        while(lv_count < level){
            vector<int> tmp;
            for(int f : level_friend){
                if(!visited[f]){
                    for(int f1 : friends[f]){
                        if(!visited[f1]){
                            tmp.push_back(f1);
                        }
                    }
                    visited[f] = true;
                }
            }
            level_friend = tmp;
            lv_count ++;
        }
        map<string, int> strToCountVideo;
        for(int f : level_friend){
            for(string video : watchedVideos[f]){
                if(strToCountVideo.find(video) == strToCountVideo.end()){
                    strToCountVideo[video] = 1;
                }else{
                    strToCountVideo[video] += 1;
                }
            }
        }
        vector<pair<string, int>> vans;
        for(map<string, int>::const_iterator it = strToCountVideo.begin(); it != strToCountVideo.end(); it ++){
            vans.push_back(make_pair(it->first, it->second));
        }
        sort(vans.begin(), vans.end(), [](const pair<string, int>&i, const pair<string, int>&j){
            return i.second == j.second ? i.first < j.first : i.second < j.second;
        });
        vector<string> ans;
        for(pair<string, int> elem : vans){
            ans.push_back(elem.first);
        }
        return ans;
    }
};

int main(){
    Solution sol;
    vector<vector<string>> watchedVideos1({{"A", "B"}, {"C"}, {"B", "C"}, {"D"}});
    vector<vector<int>> friends1({{1, 2}, {0, 3}, {0, 3}, {1, 2}});
    int id1 = 0, level1 = 1;
    vector<string> ans1 = sol.watchedVideosByFriends(watchedVideos1, friends1, 0, 1);
    for(string movie : ans1){
        cout << movie << ",";
    }
    cout << endl;

    vector<string> ans2 = sol.watchedVideosByFriends(watchedVideos1, friends1, 0, 2);
    for(string movie : ans2){
        cout << movie << ",";
    }
    cout << endl;
}