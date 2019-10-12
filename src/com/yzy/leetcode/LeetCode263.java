package com.yzy.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 编写一个程序判断给定的数是否为丑数。

 丑数就是只包含质因数 2, 3, 5 的正整数。

 示例 1:

 输入: 6
 输出: true
 解释: 6 = 2 × 3
 示例 2:

 输入: 8
 输出: true
 解释: 8 = 2 × 2 × 2
 示例 3:

 输入: 14
 输出: false
 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
 说明：

 1 是丑数。
 输入不会超过 32 位有符号整数的范围: [−231,  231 − 1]。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/ugly-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode263 {

    public static void main(String[] args) {

        int n = 7;
        boolean head = solution(n);
        System.out.println(head);

    }

    public static boolean solution(int n) {
        if (n <= 0) return false;

        while (true) {
            if (n == 1) return true;
            if (n % 2 == 0) {
                n = n >> 1;
                continue;
            }
            if (n % 3 == 0) {
                n /= 3;
                continue;
            }
            if (n % 5 == 0) {
                n /= 5;
                continue;
            }
            return false;
        }
    }

}
