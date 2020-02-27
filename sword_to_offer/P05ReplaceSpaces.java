package sword_to_offer;

/**
 * P05ReplaceSpaces
 */
public class P05ReplaceSpaces {

    public String replaceSpace(String s) {
        // 实现剑指offer的算法
        // 异常情况处理
        if(s == null || s.length() == 0){
            return "";
        }
        // 1) 计数s有多少空白字符
        int white_space_num = 0;
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == ' '){
                white_space_num += 1;
            }
        }
        // 2) 生成足够长的字符数组，设置前移的下标p1指向字符串的尾部，设置前移下标p2指向字符数组尾部
        char[] res = new char[s.length() + white_space_num * 2];
        int p1 = s.length() - 1, p2 = res.length - 1;
        // 3) 前移p1同时，如果p1不为空字符，则把p1所指值赋值给p2，如果p1为空字符，则把依次移动p2并赋值%20
        while(p1 >= 0){
            if(s.charAt(p1) == ' '){
                p1 --;
                res[p2 --] = '0';
                res[p2 --] = '2';
                res[p2 --] = '%';
            }else{
                res[p2 --] = s.charAt(p1 --);
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        P05ReplaceSpaces sol = new P05ReplaceSpaces();
        String ans;
        // test0: 标准测试用例
        ans = sol.replaceSpace("We are happy.");
        assert "We%20are%20happy.".equals(ans);
        // test1: 空白在字符串开始
        ans = sol.replaceSpace(" HelloWorld");
        assert "%20HelloWorld".equals(ans);
        // test2: 空白在字符串结束
        ans = sol.replaceSpace("HelloWorld ");
        assert "HelloWorld%20".equals(ans);
        // test3: 空白在字符串中间
        ans = sol.replaceSpace("Hello World");
        assert "Hello%20World".equals(ans);
        // test4: 连续空白字符串
        ans = sol.replaceSpace("He  ll oWo rld");
        assert "He%20%20ll%20oWo%20rld".equals(ans);
        // test5: 无空白字符串
        ans = sol.replaceSpace("HelloWorld");
        assert "HelloWorld".equals(ans);
        // test6: 空引用和空字符
        ans = sol.replaceSpace(null);
        assert ans.length() == 0;
        ans = sol.replaceSpace("");
        assert ans.length() == 0;
    }
}