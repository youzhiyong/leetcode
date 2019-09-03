package com.yzy.leetcode;

import java.util.Arrays;

/**
 * Description:
    n个人参加比赛，结束后每个人一个分数。
    领奖时所有人依次排成一圈，第一个和第n个相邻。
    要求:
    1.如果某个人的分数比旁边的人高，那么奖品数量也要比他多。
    2.每个至少得一个奖品。
    问最少应该准备多少个奖品?
    求解思路：化环为直，动态调整循环次数
 * Date: 2019-09-03
 *
 * @author youzhiyong
 */
public class Other02 {

    public static void main(String[] args) {
        int[] scores = new int[] {1,5,5,4,5};
        int res = solution(scores);
        System.out.println(res);
    }

    public static int solution(int[] scores) {
        int[] gifs = new int[scores.length];
        //初始化
        for (int i=0; i<scores.length; i++) {
            gifs[i] = 1;
        }

        //计算
        if (scores.length > 2) {

            //处理中间的数
            for (int i=1;i < scores.length - 1;i++) {
                if (scores[i] > scores[i-1]) gifs[i] = gifs[i-1] + 1;
                if (scores[i] > scores[i+1]) gifs[i] = gifs[i+1] + 1;
            }

            //处理第一个数
            if (scores[0] > scores[1]) gifs[0] = gifs[1] + 1;
            if (scores[0] > scores[scores.length - 1]) gifs[0] = gifs[scores.length - 1] + 1;

            //处理最后一个数
            if (scores[scores.length - 1] > scores[0]) gifs[scores.length - 1] = gifs[0] + 1;
            if (scores[scores.length - 1] > scores[scores.length - 2]) gifs[scores.length - 1] = gifs[scores.length - 2] + 1;

        } else if (scores.length == 2){
            return 3;
        } else return 1;


        return Arrays.stream(gifs).sum();
    }

}
