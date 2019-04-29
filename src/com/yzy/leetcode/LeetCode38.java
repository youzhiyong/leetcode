package com.yzy.leetcode;

/**
 * Description:
 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 6.     312211
 7.     13112221
 8.     1113213211
 8.     31131211131221
 1 被读作  "one 1"  ("一个一") , 即 11。
 11 被读作 "two 1s" ("两个一"）, 即 21。
 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。

 注意：整数顺序将表示为一个字符串。


 示例 1:

 输入: 1
 输出: "1"
 示例 2:

 输入: 4
 输出: "1211"


 执行用时 : 5 ms, 在Count and Say的Java提交中击败了77.55% 的用户
 内存消耗 : 34 MB, 在Count and Say的Java提交中击败了92.74% 的用户
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode38 {

    public static void main(String[] args) {

        String head = solution(9);
        System.out.println(head);
    }

    public static String solution(int n) {
        StringBuilder builder = new StringBuilder("1");
        StringBuilder newBuilder = new StringBuilder();
        while (n > 1) {
            int num = 1;
            char ch = builder.charAt(0);
            for (int i=1; i<builder.length();i++) {
                if (builder.charAt(i) == ch) num++;
                else {
                    newBuilder.append(num).append(ch);
                    num = 1;
                    ch = builder.charAt(i);
                }
            }
            newBuilder.append(num).append(ch);
            builder.delete(0, builder.length()).append(newBuilder);
            newBuilder.delete(0, newBuilder.length());
            n--;
        }
        return builder.toString();
    }

}
