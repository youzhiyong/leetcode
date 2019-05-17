package com.yzy.leetcode;


/**
 * Description:
 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

 示例 1:
 输入: [7,1,5,3,6,4]
 输出: 7
 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。

 示例 2:
 输入: [1,2,3,4,5]
 输出: 4
 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。

 示例 3:
 输入: [7,6,4,3,1]
 输出: 0
 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode122 {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 6, 2, 3, 1};
        int res = solution2(nums);
        System.out.println(res);
    }

    /**
     * 思路：第一天默认买入，记录买入的值 head, 然后只要今天 today 比昨天 yesterday 小，就把昨天的就卖出(yesterday - head)，然后今天的买入
     * 如 1-6-4-2-3
     * 第一天 1 默认买入
     * 第三天小于第二天，第二天卖出，6 - 1，今天的 4 买入
     * 第四天小于第三天，第三天卖出，4 - 4，今天的 2 买入
     * 注意最后一天，若最后一天大于买入金额，还要再算一次收益
     * @param prices
     * @return
     */
    public static int solution(int[] prices) {
        if (prices.length < 2) return 0;
        int profit = 0; //总收益
        int yesterday = prices[0]; //被比较元素的前一个元素
        int head = prices[0]; //局部最小值，也就是局部的第一个值
        for (int today : prices) {
            if (today < yesterday) {
                profit += (yesterday - head);
                head = today;
            }
            yesterday = today;
        }
        if (yesterday > head) profit += (yesterday - head);
        return profit;
    }

    /**
     * 今天比昨天多就卖出
     */
    public static int solution2(int[] prices) {
        if (prices.length < 2) return 0;
        int profit = 0; //总收益
        int yesterday = prices[0]; //前一天价格
        for (int today : prices) {
            if (today > yesterday) profit += (today - yesterday);
            yesterday = today;
        }
        return profit;
    }


}
