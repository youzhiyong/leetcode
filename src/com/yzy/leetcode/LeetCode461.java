package com.yzy.leetcode;

/**
 * Description:
 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

 给出两个整数 x 和 y，计算它们之间的汉明距离。

 注意：
 0 ≤ x, y < 231.

 示例:

 输入: x = 1, y = 4

 输出: 2

 解释:
 1   (0 0 0 1)
 4   (0 1 0 0)
      ↑   ↑

 上面的箭头指出了对应二进制位不同的位置。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/hamming-distance

 * @see LeetCode191
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode461 {

    public static void main(String[] args) {

        int head = solution(1, 2);
        System.out.println(head);

    }
    public static int solution(int x, int y) {
        // 1. 将x和y进行异或运算，则转换成求二进制位中1的个数
        int n = x ^ y;
        // 2. 求二进制中1的个数
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int temp = n >> i;
            temp = temp & 1;
            result += temp; //temp只有可能为 0 或者 1
        }
        return result;
    }


}
