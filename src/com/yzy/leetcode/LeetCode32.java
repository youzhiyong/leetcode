package com.yzy.leetcode;

/**
 * Description:
 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

 示例 1:

 输入: "(()"
 输出: 2
 解释: 最长有效括号子串为 "()"
 示例 2:

 输入: ")()())"
 输出: 4
 解释: 最长有效括号子串为 "()()"
 在真实的面试中遇到过这道题？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode32 {

    public static void main(String[] args) {
        String s = "()(()()";

        int head = solution(s);
        System.out.println(head);
    }

    /**
     * 两遍遍历法，分别 从左到右 和 从右到左
     * 方法：left和right遍历分别记录遍历到的 '(' 和 ')'的个数
     * 当 left和right相等时，记录下长度
     * 当 right>left 时(从左向右遍历时)，重置left和right的值
     *
     * 为什么要遍历两次？
     * 实际测试一个例子就知道了
     * 如 "()(()()"  若只从左向右遍历，max的值是 2，实际是4
     *
     * @param s
     * @return
     */
    public static int solution(String s) {

        int max = 0, left = 0, right = 0;

        //从左到右遍历
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(') left++;
            else if (s.charAt(i) == ')') right++;

            if (left == right) max = Math.max(max, left + right);
            else if (right > left) left = right = 0;
        }

        //重置left和right变量，从右到左遍历
        left = right = 0;
        for (int i=s.length()-1;i>=0;i--) {
            if (s.charAt(i) == ')') right++;
            else if (s.charAt(i) == '(') left++;

            if (left == right) max = Math.max(max, left + right);
            else if (left > right) left = right = 0;
        }

        return max;

    }

}
