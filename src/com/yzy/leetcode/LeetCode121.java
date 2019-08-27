package com.yzy.leetcode;


/**
 * Description:
 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

 注意你不能在买入股票前卖出股票。

 示例 1:

 输入: [7,1,5,3,6,4]
 输出: 5
 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 示例 2:

 输入: [7,6,4,3,1]
 输出: 0
 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode121 {

    public static void main(String[] args) {
        int[] nums = new int[] {2,7,1,4};
        int res = solution2(nums);
        System.out.println(res);
    }

    //动态规划 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格} !!!
    // f(n) = max(f(n-1), prices[n] - min);
    public static int solution(int[] prices) {
        int max = 0, min = prices[0];
        for (int i : prices) {
            min = Math.min(min, i);
            max = Math.max(max, i - min);
        }
        return max;
    }

    //双指针 找一个左边的最小值和右边的最大值
    //====思路有问题，不一定是 左边的最小值和右边的最大值 才是最佳答案，比如  2，7，1，4
    // Error
    public static int solution2(int[] prices) {
        if (prices.length == 0) return 0;
        int left = 0;
        int right = prices.length - 1;
        int minIndex = left;    //最小值对应的索引
        int maxIndex = right;   //最大值对应的索引

        while (true) {
            if (left <= maxIndex) {
                if (prices[minIndex] > prices[left]) minIndex = left;
                left++;
            }

            if (right >= minIndex) {
                if (prices[maxIndex] < prices[right]) maxIndex = right;
                right--;
            }

            if (left > maxIndex && right < minIndex){
                break;
            }
        }

        return Math.max(0, prices[maxIndex] - prices[minIndex]);
    }




}
