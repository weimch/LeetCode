package sword_to_offer;

import java.util.HashSet;
import java.util.Set;

/**
 * P38Permutation
 */
public class P38Permutation {

    StringBuilder stringBuilder;
    Set<String> ans;

    public String[] permutation(String s) {
        // 使用递归, 每次递归中, 持续地, 交换第一个元素和其后面元素的值, 直到只剩一个元素为止
        stringBuilder = new StringBuilder();
        ans = new HashSet<>();
        helper(s.toCharArray(), 0);
        return ans.toArray(new String[0]);
    }

    void helper(char[] s, int start){
        if(s.length - 1 == start){
            stringBuilder.append(s[start]);
            ans.add(stringBuilder.toString());
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            return ;
        }
        stringBuilder.append(s[start]);
        helper(s, start + 1);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        for(int i = start + 1; i < s.length; i ++){
            if(s[i] == s[start]) continue;
            char tmp = s[start];
            s[start] = s[i];
            s[i] = tmp;
            stringBuilder.append(s[start]);
            helper(s, start + 1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            s[i] = s[start];
            s[start] = tmp;
        }
    }

}