package com.yzy.leetcode;

import com.yzy.common.ListNode;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。

 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）


 例子:

 输入: N = 1, K = 1
 输出: 0

 输入: N = 2, K = 1
 输出: 0

 输入: N = 2, K = 2
 输出: 1

 输入: N = 4, K = 5
 输出: 1

 解释:
 第一行: 0
 第二行: 01
 第三行: 0110
 第四行: 01101001

 注意：

 N 的范围 [1, 30].
 K 的范围 [1, 2^(N-1)].

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode779 {

    public static void main(String[] args) {

        int head = solution4(5, 14);
        System.out.println(head);

    }

    //超出内存限制！！！
    public static int solution(int N, int k) {
        if (N == 1) return 0;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        while (i++ < N) {
            StringBuilder temp = new StringBuilder();
            for (char ch : sb.toString().toCharArray()) {
                if (ch == '1') {
                    temp.append("10");
                } else {
                    temp.append("01");
                }
            }
            sb = temp;
        }
        return sb.charAt(k - 1) - '0';
    }

    // 0 -> 01
    // 1 -> 10
    //思路：要想知道第N行第K个数是0还是1，只需要知道他对应的上一行(N-1)的第(K+1 / 2) 个数是0还是1, 再基于K的奇偶来判断是第一个数还是第二个数
    //测试通过！
    public static int solution2(int N, int K) {
        if (K == 1) return 0;

        List<Integer> list = new ArrayList<>();
        list.add(K);
        while (K > 2 && N-- > 0) {
            K = (K + 1) >> 1;
            list.add(K);
        }

        int res = list.get(list.size() - 1) == 1 ? 0 : 1;
        if (list.size() == 1) return res;
        for (int i = list.size() - 2; i >= 0; i--) {
            int n = list.get(i);
            if (res == 0) { //如果上一列的 父数字 是 0，则他会产生 0 1 两个 子数字
                res = n % 2 == 1 ? 0 : 1;   // 若 n 为奇数，则他是第一个子数字，即为 0，否则为1    这里的n是你在本一列的索引，索引是从1开始的
            } else { // res == 1
                res = n % 2 == 1 ? 1 : 0;
            }
        }

        return res;
    }

    //对 solution2 的优化
    public static int solution3(int N, int K) {
        if (K == 1) return 0;

        List<Boolean> list = new ArrayList<>();
        list.add(K % 2 == 0);  // true表示在偶数位
        while (K > 2 && N-- > 0) {
            K = (K + 1) >> 1;
            list.add(K % 2 == 0);
        }

        boolean res = list.get(list.size() - 1);   // 最上层的那个数，如果索引是奇数，则是第一个元素，则为0，否则为偶数，第二个数，即1   由于只有0和1两种状态，可以直接转换成boolean值，方便后续计算
        if (list.size() == 1) return res ? 1 : 0;
        for (int i = list.size() - 2; i >= 0; i--) {
            res ^= list.get(i);
        }

        return res ? 1 : 0;
    }


    //对 solution3 的优化

    /**
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :33 MB, 在所有 java 提交中击败了86.42%的用户
     * @return
     */
    public static int solution4(int N, int K) {
        if (K == 1) return 0;

        boolean flag = K % 2 == 0;
        while (K > 2 && N-- > 0) {
            K = (K + 1) >> 1;
            flag ^= K % 2 == 0;
        }
        return flag ? 1 : 0;
    }





}
