package com.yzy.leetcode;

import com.yzy.common.TreeNode;

/**
 * Description:
 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

 说明: 叶子节点是指没有子节点的节点。

 示例:
 给定如下二叉树，以及目标和 sum = 22，

           5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
   7    2      1
 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode112 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        TreeNode root1 = new TreeNode(-3);
        /*TreeNode root2 = new TreeNode(8);
        TreeNode root3 = new TreeNode(11);
        TreeNode root4 = new TreeNode(13);
        TreeNode root5 = new TreeNode(4);
        TreeNode root6 = new TreeNode(7);
        TreeNode root7 = new TreeNode(2);
        TreeNode root8 = new TreeNode(1);*/
        root.left = root1;
        /*root.right = root2;

        root1.left = root3;

        root2.left = root4;
        root2.right = root5;

        root5.right = root8;

        root3.left = root6;
        root3.right = root7;*/

        boolean head = solution(root, -5);
        System.out.println(head);
    }

    public static boolean solution(TreeNode root, int sum) {
        return hasPathSum(root, sum);
    }

    /**
     * 大部分二叉树的问题在递归处理时都可以分四种情况
     * 1. 节点为空
     * 2. 节点不为空，但是左右子节点都为空
     * 3. 节点不为空，左右子节点不同时为空
     *      3.1 左节点为空，右节点不为空
     *      3.2 左节点不为空，右节点为空
     * 4. 左右节点都不为空
     * @param root
     * @param sum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null/* || root.val > sum*/) return false;   //有负数！！！
        if (root.left == null && root.right == null) return root.val == sum;
        if (root.left == null) return hasPathSum(root.right, sum - root.val);
        if (root.right == null) return hasPathSum(root.left, sum - root.val);
        return hasPathSum(root.right, sum - root.val) || hasPathSum(root.left, sum - root.val);
    }


}
