package com.yzy.leetcode;

/**
 * Description:
 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

 如果不存在最后一个单词，请返回 0 。

 说明：一个单词是指由字母组成，但不包含任何空格的字符串。

 示例:

 输入: "Hello World"
 输出: 5
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode58 {

    public static void main(String[] args) {
        String input = "hello world";

        int head = solution(input);
        System.out.println(head);
    }

    public static int solution(String s) {
        int len = 0;
        boolean flag = false;
        for (int i=s.length()-1; i>=0; i--) {

            if (flag && s.charAt(i) == ' ') {
                break;
            }

            if (s.charAt(i) != ' ') {
                flag = true;
                len++;
            }
        }
        return len;
    }

}
