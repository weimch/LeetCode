package sword_to_offer;

import java.util.HashSet;
import java.util.Set;

/**
 * P46TranslateNum
 */
public class P46TranslateNum {

    Set<String> translateString;
    String numstr;
    int numstr_idx;
    public int translateNum(int num) {
        // 深度优先搜索 首先放入第一个数字, 如果加上第二个数字合法, 遍历第二个数字
        translateString = new HashSet<>();
        numstr_idx = 0;
        numstr = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        dfs(sb);
        return translateString.size();
    }
    void dfs(StringBuilder sb){
        if(numstr_idx == numstr.length()){
            translateString.add(sb.toString());
            return ;
        }
        sb.append((char)('a' + (numstr.charAt(numstr_idx) - '0')));
        numstr_idx ++;
        dfs(sb);
        numstr_idx --;
        sb.deleteCharAt(sb.length()-1);
        if(numstr.charAt(numstr_idx) == '0' || numstr_idx + 2 > numstr.length()) return;
        int ch_offset = Integer.parseInt(numstr.substring(numstr_idx, numstr_idx + 2));
        if(ch_offset <= 25) {
            sb.append((char)('a' + ch_offset));
            numstr_idx += 2;
            dfs(sb);
            numstr_idx -= 2;
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        P46TranslateNum sol = new P46TranslateNum();
        assert sol.translateNum(506) == 1;
        assert sol.translateNum(25) == 2;
        assert sol.translateNum(12258) == 5;
    }
}