package com.yzy.leetcode;

/**
 * Description:
完全背包问题

 有 N 件物品和一个容量是 M 的背包。每件物品可以使用多次
 第 i 件物品的体积是 vi，价值是 wi。
 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 输出最大价值。
 * Date: 2019-09-03
 *
 * @author youzhiyong
 */
public class Other05 {

    public static void main(String[] args) {
        int n = 4;  // n 表示物品数量
        int m = 6;  // m 表示背包容量
        // w_v是二维数组， 第一列表示物品重量，第二列表示物品价值
        int[][] w_v = new int[][] {{1,1}, {2,3}, {4,7}, {5,8}};
        int res = solution(n, m, w_v);
        System.out.println(res);
    }

    // 完全背包  物品可重复使用
    public static int solution(int n, int m, int[][] w_v) {

        int[][] sum_v = new int[n+1][m+1];
        for (int i=1; i<=n; i++) {   // 逐个添加物品
            for (int j=1;j<=m;j++) {  //逐个增加容量
                if (w_v[i-1][0] <= j) {  //若当前添加的物品 小于或者等于 当前容量， 则有两种情况：放入背包或者不放
                    // 放入之后的总价值为 sum_v[i - 1][j- r * w_v[i-1][0]] + r * w_v[i-1][1],  即为 当前物品的价值 + [剩余容量(容量j-当前物品重量) 与 前i-1个物品之间的最大价值]
                    // 不放则为 容量j 与 前i-1个物品之间的最大价值
                    int r = j / w_v[i-1][0];  //这里与01背包的区别是：01背包中当前物品只能用一次，这里可以使用多次，如果可以的话，同样，使用多次后对应的重量和价值都要增加
                    sum_v[i][j] = Math.max(sum_v[i - 1][j - r * w_v[i-1][0]] + r * w_v[i-1][1], sum_v[i-1][j]);
                } else {
                    sum_v[i][j] = sum_v[i-1][j];
                }
            }

        }

        return sum_v[n][m];
    }

}
