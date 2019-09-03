package com.yzy.leetcode;

/**
 * Description:
多重背包问题

 有 N 件物品和一个容量是 M 的背包。每件物品可以使用多次，但有数量限制
 第 i 件物品的体积是 vi，价值是 wi。 数量是 si
 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 输出最大价值。
 * Date: 2019-09-03
 *
 * @author youzhiyong
 */
public class Other06 {

    public static void main(String[] args) {
        int n = 4;  // n 表示物品数量
        int m = 6;  // m 表示背包容量
        // w_v是二维数组， 第一列表示物品重量，第二列表示物品价值
        int[][] w_v = new int[][] {{1,1}, {2,3}, {4,7}, {5,8}};
        int [] s = new int[] {3, 2, 2, 1};
        int res = solution(n, m, w_v, s);
        System.out.println(res);
    }

    // 多重背包问题 物品可重复使用，但有数量限制
    public static int solution(int n, int m, int[][] w_v, int[] s) {

        int[][] sum_v = new int[n+1][m+1];
        for (int i=1; i<=n; i++) {
            for (int j=1;j<=m;j++) {
                if (w_v[i-1][0] <= j) {
                    int num = j / w_v[i-1][0];
                    int r = (num > s[i - 1]) ? s[i - 1] : num;  //这里与完全背包的区别是：完全背包中不限制物品数量，这里有限制数量
                    sum_v[i][j] = Math.max(sum_v[i - 1][j - r * w_v[i-1][0]] + r * w_v[i-1][1], sum_v[i-1][j]);
                } else {
                    sum_v[i][j] = sum_v[i-1][j];
                }
            }


        }

        return sum_v[n][m];
    }

}
