package com.yzy.leetcode;

/**
 * Description:
 回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。

 给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。

  

 示例 1：

 输入：[[1,1],[2,3],[3,2]]
 输出：true
 示例 2：

 输入：[[1,1],[2,2],[3,3]]
 输出：false
  

 提示：

 points.length == 3
 points[i].length == 2
 0 <= points[i][j] <= 100

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/valid-boomerang
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Date: 2019-04-29
 *
 * @author youzhiyong
 */
public class LeetCode1037 {

    public static void main(String[] args) {

        //[[1,1],[2,3],[3,2]]
        //[[52,86],[12,65],[24,71]]
        int[][] p = new int[][] {{52, 86}, {12, 65}, {24, 71}};
        boolean exist = solution(p);
        System.out.println(exist);
    }

    /**
     * 思路1，通过前两个点 得到一个直线方程  y = ax + b
     * 然后看第三个点是否满足次方程 即可确定是否在同一直线上
     * 但是 代码似乎无法直接实现求解方程  。。。  只能通过穷举法实现 不太好
     *
     *
     * 思路2，若三个点不在一条直线上，则这三个点可以组成一个三角形，所以就有  两条边的长度和不等于第三边的长度
     * 但是 求长度需要开更号 ...
     *
     * 思路3，在思路1 的基础上，若三个点 两两之间的斜率相同，则表示他们在同一条直线上
     * 斜率 = 两点的垂直距离 / 两点的水平距离
     * @param points
     * @return
     */
    public static boolean solution(int[][] points) {

        //如果有两个点相同
        if (((points[0][0] == points[1][0]) && points[0][1] == points[1][1])
            || ((points[1][0] == points[2][0]) && points[1][1] == points[2][1])
            || ((points[0][0] == points[2][0]) && points[0][1] == points[2][1])) return false;

        //横坐标或者纵坐标都在一条直线上
        if ((points[0][0] == points[1][0] && points[1][0] == points[2][0])
                || (points[0][1] == points[1][1] && points[1][1] == points[2][1])) return false;

        //横坐标或者纵坐标有两个点在一条直线上
        if ((points[0][0] == points[1][0] || points[1][0] == points[2][0] || points[0][0] == points[2][0])
                || (points[0][1] == points[1][1] || points[1][1] == points[2][1] || points[0][1] == points[2][1])) return true;

        return !((Math.abs((points[0][1] - points[1][1]) / (double)(points[0][0] - points[1][0])) == Math.abs((points[0][1] - points[2][1]) / (double)(points[0][0] - points[2][0])))
                && (Math.abs((points[0][1] - points[2][1]) / (double)(points[0][0] - points[2][0])) == Math.abs((points[1][1] - points[2][1]) / (double)(points[1][0] - points[2][0]))));

    }


}
