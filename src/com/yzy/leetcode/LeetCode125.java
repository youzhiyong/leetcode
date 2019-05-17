package com.yzy.leetcode;


/**
 * Description:
 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

 说明：本题中，我们将空字符串定义为有效的回文串。

 示例 1:
 输入: "A man, a plan, a canal: Panama"
        "aman,aplan,acanal:panama"
 输出: true

 示例 2:
 输入: "race a car"
 输出: false

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode125 {

    public static void main(String[] args) {
        String s = "abaa";
        boolean res = solution2(s);
        System.out.println(res);
    }

    /**
     * 先计算出两个子串，再判断是否相等
     * @param s
     * @return
     */
    public static boolean solution(String s) {
        String str = s.toLowerCase();
        StringBuilder one = new StringBuilder();
        StringBuilder two = new StringBuilder();
        int i = 0, j = str.length() - 1;
        while (i < j) {
            while (i < str.length()) {
                char c = str.charAt(i++);
                if (isValid(c)) {
                    one.append(c);
                    break;
                }
            }
            while (j >= 0) {
                char c = str.charAt(j--);
                if (isValid(c)) {
                    two.append(c);
                    break;
                }
            }
        }
        return one.toString().equals(two.toString());
    }

    /**
     * 不需要计算出完整的两个子串，中途有一个错误则返回失败
     * @param s
     * @return
     */
    public static boolean solution2(String s) {
        int i = 0, j = s.length() - 1;
        char a, b;
        while (i < j) {
            while (!isValid(a = s.charAt(i++)) && i < s.length() - 1) {}
            while (!isValid(b = s.charAt(j--)) && j >= 0) {}
            if (isValid(a) && isValid(b) && !isEqual(a, b)) return false;
        }
        return true;
    }

    private static boolean isEqual(char a, char b) {
        return (a >= 'a' ? a - ('a' - 'A') : a) == (b >= 'a' ? b - ('a' - 'A') : b);
    }

    private static boolean isValid(char c) {
        return  (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

}
