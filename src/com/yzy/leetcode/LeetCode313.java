package com.yzy.leetcode;

/**
 * Description:
 编写一段程序来查找第 n 个超级丑数。

 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。

 示例:

 输入: n = 12, primes = [2,7,13,19]
 输出: 32
 解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 说明:

 1 是任何给定 primes 的超级丑数。
  给定 primes 中的数字以升序排列。
 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
 第 n 个超级丑数确保在 32 位有符整数范围内。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/super-ugly-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Date: 2019-02-27
 *
 * @author youzhiyong
 *
 *
 * @see LeetCode263  判断一个数是否为丑数
 * @see LeetCode264  查找第 n 个丑数
 */
public class LeetCode313 {

    public static void main(String[] args) {
        int n = 12;
        int[] primes = new int[] {2,7,13,19};
        int head = solution(n, primes);
        System.out.println(head);
    }

    /**
     * 参考LeetCode264 的 三指针 + 动态规划 法
     *
     * 不同点：LeetCode264 中 基数是固定的 即 {2,3,5}，  在此题中基数是作为参数传进来的
     *
     * 使用 动态多指针 + 动态规划
     *
     * 思路：下一个丑数一定是 前面的某一个丑数 * 基数{primes} 中的一个数得来的一个最小的数
     *
     * @param n
     * @return
     */
    public static int solution(int n, int[] primes) {

        int[] dp = new int[n];
        dp[0] = 1;

        int[] point = new int[primes.length];

        for (int i = 1; i < n; i++) {
            int min = dp[point[0]] * primes[0];
            for (int j = 1; j<primes.length; j++) {
                min = Math.min(min, dp[point[j]] * primes[j]);
            }
            dp[i] = min;
            for (int j = 0; j<primes.length; j++) {
                if (min / primes[j] == dp[point[j]]) point[j]++;
            }
        }

        return dp[n-1];
    }

}
