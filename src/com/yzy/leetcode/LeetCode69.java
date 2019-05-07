package com.yzy.leetcode;

/**
 * Description:
 实现 int sqrt(int x) 函数。

 计算并返回 x 的平方根，其中 x 是非负整数。

 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

 示例 1:

 输入: 4
 输出: 2
 示例 2:

 输入: 8
 输出: 2
 说明: 8 的平方根是 2.82842...,
 由于返回类型是整数，小数部分将被舍去。

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode69 {

    public static void main(String[] args) {
        int a = 8;
        int head = solution(a);
        System.out.println(head);
    }

    //二分法 初始左边界 0，初始右边界 x.
    public static int solution(int x) {
        if (x == 0 || x == 1) return x;
        int left = 0; //初始左边界 0
        int right = x;  //初始右边界 x
        while (left < right) {
            int mid = (right + left) >> 1;
            if (x / mid == mid) return mid;  //这里不要使用 mid * mid == x  会导致int溢出
            if (x / mid > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right * right > x ? --right : right;
    }

    //二分法 初始左边界 0，初始右边界 x.
    public static int solution2(int x) {
        if(x == 0 || x == 1) return x;
        int l = 0;
        int r = x;
        while (l <= r){
            int mid = (l+r) >> 1;
            if(mid == x/mid) return mid;
            if(x/mid > mid) l = mid+1;
            else r= mid-1;
        }
        return r;
    }

}
