package com.yzy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。


 在杨辉三角中，每个数是它左上方和右上方的数的和。

 示例:

 输入: 5
 输出:
 [
      [1],
     [1,1],
    [1,2,1],
   [1,3,3,1],
  [1,4,6,4,1]
 ]

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode118 {

    public static void main(String[] args) {

        List head = solution(5);
        System.out.println(head);
    }

    public static List<List<Integer>> solution(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows == 0) return lists;
        if (numRows >= 1)  lists.add(Arrays.asList(1));
        if (numRows >= 2)  lists.add(Arrays.asList(1, 1));
        if (numRows >= 3)  lists.add(Arrays.asList(1, 2, 1));
        int i = 4;
        while (i <= numRows) {
            List<Integer> preLine = lists.get(lists.size() - 1);
            List<Integer>  line = new ArrayList<>();
            line.add(1);
            for (int n = 0; n < (i - 2); n++) {
                line.add(preLine.get(n) + preLine.get(n + 1));
            }
            line.add(1);
            lists.add(line);
            i++;
        }

        return lists;
    }


}
