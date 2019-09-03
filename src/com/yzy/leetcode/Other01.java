package com.yzy.leetcode;

/**
 * Description:
 * 规则：
 * 1.
 * 。比如:helllo --> hello
 * 2.两对一样的字母(AABB型)连在一起，一定是拼写错误，去掉第二对的第一个字母。比如:helloo --> hello
 * 3.上面的规则优先从左到右匹配，即如果是AABBCC型，应优先考虑修复AABB为AABCC。
 * 输入：
 * 一串字符串
 * 输出：
 * 修正后的字符串
 * Date: 2019-09-03
 *
 * @author youzhiyong
 */
public class Other01 {

    public static void main(String[] args) {
        String str = "hellloooooo";
        String res = solution(str);
        System.out.println(res);
    }

    public static String solution(String str) {

        char[] chars = str.toCharArray();
        StringBuilder builder = new StringBuilder();  //新建空间存放正常字母

        for (char ch : chars) {

            if (builder.length() < 2) {
                builder.append(ch);
                continue;
            }
            if (builder.charAt(builder.length() - 1) == ch && builder.charAt(builder.length() - 2) == ch){
                continue; // 3个字母相同  则最后一个过滤掉
            }
            if (builder.length() >=3 && builder.charAt(builder.length() - 2) == builder.charAt(builder.length() - 3) && builder.charAt(builder.length() - 1) == ch) {
                continue; // 若有 xxoo 的字母，则最后一个o过滤掉
            }
            builder.append(ch);  //正常则添加
        }

        return builder.toString();
    }

}
