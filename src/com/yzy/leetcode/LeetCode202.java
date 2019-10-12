package com.yzy.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 编写一个算法来判断一个数是不是“快乐数”。

 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。

 示例: 

 输入: 19
 输出: true
 解释:
 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/happy-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode202 {

    public static void main(String[] args) {

        int n = 4;
        boolean head = solution2(n);
        System.out.println(head);

    }

    //暴力法，计算100次，若结果还不为1，则认为是不快乐数
    public static boolean solution(int n) {

        int times = 0;

        while (times < 100) {
            //System.out.println(n);
            if (n == 1) return true;
            times++;
            int s = 0;
            while (n > 0) {
                s += (n % 10) * (n % 10);
                n = n / 10;
            }
            n = s;
        }
        return false;

    }

    //通过暴力法打印出来的中间结果发现，所有的不快乐数最终都会进入到 4 16 37 58 89 145 42 20 这个死循环中去
    public static boolean solution2(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(4);
        set.add(16);
        set.add(37);
        set.add(58);
        set.add(89);
        set.add(145);
        set.add(42);
        set.add(20);
        while (true) {
            if (n == 1) return true;
            if (set.contains(n)) return false;
            int s = 0;
            while (n > 0) {
                s += (n % 10) * (n % 10);
                n = n / 10;
            }
            n = s;
        }
    }

    //通过暴力法打印出来的中间结果发现，所有的不快乐数最终都会进入到 4 16 37 58 89 145 42 20 这个死循环中去
    public static boolean solution3(int n) {
        while (true) {
            if (n == 1) return true;
            if (n == 4) return false;  //这里和 solution2的思想一样，但是我们只需要判断死循环中的一个数即可
            int s = 0;
            while (n > 0) {
                s += (n % 10) * (n % 10);
                n = n / 10;
            }
            n = s;
        }
    }


}
