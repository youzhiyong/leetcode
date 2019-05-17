package com.yzy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。

 在杨辉三角中，每个数是它左上方和右上方的数的和。

 示例:

 输入: 3
 输出: [1,3,3,1]
 进阶：

 你可以优化你的算法到 O(k) 空间复杂度吗？

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode119 {

    public static void main(String[] args) {

        List head = solution(5);
        System.out.println(head);
    }

    public static List<Integer> solution(int rowIndex) {

        if (rowIndex == 0) return Arrays.asList(1);
        if (rowIndex == 1)  return Arrays.asList(1, 1);
        if (rowIndex == 2)  return Arrays.asList(1, 2, 1);
        if (rowIndex == 3)  return Arrays.asList(1, 3, 3, 1);
        int i = 4;
        List<Integer> preLine = Arrays.asList(1, 3, 3, 1);
        while (i <= rowIndex) {
            List<Integer> line = new ArrayList<>();
            line.add(1);
            for (int n = 0; n < (i - 1); n++) {
                line.add(preLine.get(n) + preLine.get(n + 1));
            }
            line.add(1);
            preLine = line;
            i++;
        }

        return preLine;
    }


}
