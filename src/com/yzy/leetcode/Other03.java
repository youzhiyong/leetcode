package com.yzy.leetcode;

/**
 * Description:
 某国货币系统包含面值1元，4元，16元，64元共计4种硬币，以及面值1024元的纸币。
 现在某人使用1024元的纸币购买了一件价格为N(0≤N≤1024)的商品。
 请问最少他会收到多少枚硬币?

 * Date: 2019-09-03
 *
 * @author youzhiyong
 */
public class Other03 {

    public static void main(String[] args) {
        int res = solution(100);
        System.out.println(res);
    }

    public static int solution(int n) {

        int coinCount = 0;
        int remain = 1024 - n;

        if (remain == 0) return 0;

        // coin 1024 当单价为0时
        if (remain == 1024) {
            return 1;
        }

        // coin 64
        if (remain >= 64) {
            coinCount += remain / 64;
            remain %= 64;
        }

        // coin 16
        if (remain >= 16) {
            coinCount += remain / 16;
            remain %= 16;
        }

        // coin 4
        if (remain >= 4) {
            coinCount += remain / 4;
            remain %= 4;
        }

        // coin 1
        coinCount += remain;

        return coinCount;
    }

}
