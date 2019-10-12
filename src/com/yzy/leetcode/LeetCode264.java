package com.yzy.leetcode;

/**
 * Description:
 编写一个程序，找出第 n 个丑数。

 丑数就是只包含质因数 2, 3, 5 的正整数。

 示例:

 输入: n = 10
 输出: 12
 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 说明:  

 1 是丑数。
 n 不超过1690。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/ugly-number-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Date: 2019-02-27
 *
 * @author youzhiyong
 *
 *
 * @see LeetCode263  判断一个数是否为丑数
 */
public class LeetCode264 {

    public static void main(String[] args) {
        int n = 20;
        int head = solution(n);
        System.out.println(head);
    }

    /**
     * 三指针 + 动态规划
     *
     * 思路：下一个丑数一定是 前面的某一个丑数 * 基数{2， 3， 5} 中的一个数得来的一个最小的数
     * 这里注意：前面的某一个丑数  不一定就是 前面的第一个丑数
     *
     * 前20个丑数：1 2 3 4 5 6 8 9 10 12 15 16 18 20 24 25 27 30 32 36 36
     *
     * 比如: 丑数 6 后面的丑数是8， 他是由 8 前面的丑数 4 * 基数{2} 计算来的
     * 比如: 丑数 8 后面的丑数是9， 他是由 9 前面的丑数 3 * 基数{3} 计算来的
     *
     * 比如: 丑数 5 后面的丑数是6， 他是由 6 前面的丑数 2 * 基数{3} 或者 丑数3 * 基数{2} 计算来的 这个时候 基数{2}和基数{3}对应的指针都应该 + 1
     * @param n
     * @return
     */
    public static int solution(int n) {

        int[] dp = new int[n];
        dp[0] = 1;

        int p_2 = 0;
        int p_3 = 0;
        int p_5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(2 * dp[p_2], Math.min(3 * dp[p_3], 5 * dp[p_5]));
            //System.out.print(min + " ");
            dp[i] = min;
            if (min / 2 == dp[p_2]) p_2++;
            if (min / 3 == dp[p_3]) p_3++;
            if (min / 5 == dp[p_5]) p_5++;
        }

        return dp[n-1];
    }

}
