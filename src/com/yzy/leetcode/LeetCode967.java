package com.yzy.leetcode;

import com.yzy.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 返回所有长度为 N 且满足其每两个连续位上的数字之间的差的绝对值为 K 的非负整数。

 请注意，除了数字 0 本身之外，答案中的每个数字都不能有前导零。例如，01 因为有一个前导零，所以是无效的；但 0 是有效的。

 你可以按任何顺序返回答案。

  

 示例 1：

 输入：N = 3, K = 7
 输出：[181,292,707,818,929]
 解释：注意，070 不是一个有效的数字，因为它有前导零。
 示例 2：

 输入：N = 2, K = 1
 输出：[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
  

 提示：

 1 <= N <= 9
 0 <= K <= 9
 在真实的面试中遇到过这道题？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/numbers-with-same-consecutive-differences
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode967 {

    public static void main(String[] args) {
        int[] list = solution(2, 1);
        System.out.println(list);

    }

    public static int[] solution(int N, int K) {
        int [][] r_0 = new int[][] {{0,0}, {1,1}, {2,2}, {3,3}, {4,4}, {5,5}, {6,6}, {7,7}, {8,8}, {9,9}};
        int [][] r_1 = new int[][] {{0,1}, {1,2}, {2,3}, {3,4}, {4,5}, {5,6}, {6,7}, {7,8}, {8,9}};
        int [][] r_2 = new int[][] {{0,2}, {1,3}, {2,4}, {3,5}, {4,6}, {5,7}, {6,8}, {7,9}};
        int [][] r_3 = new int[][] {{0,3}, {1,4}, {2,5}, {3,6}, {4,7}, {5,8}, {6,9}};
        int [][] r_4 = new int[][] {{0,4}, {1,5}, {2,6}, {3,7}, {4,8}, {5,9}};
        int [][] r_5 = new int[][] {{0,5}, {1,6}, {2,7}, {3,8}, {4,9}};
        int [][] r_6 = new int[][] {{0,6}, {1,7}, {2,8}, {3,9}};
        int [][] r_7 = new int[][] {{0,7}, {1,8}, {2,9}};
        int [][] r_8 = new int[][] {{0,8}, {1,9}};
        int [][] r_9 = new int[][] {{0,9}};
        List<Integer> res = new ArrayList<>();

        int[] resInt = new int[res.size()];
        for (int i=0; i<res.size(); i++) {
            resInt[i] = res.get(i);
        }
        return resInt;
    }


}
