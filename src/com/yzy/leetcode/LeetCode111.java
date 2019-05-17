package com.yzy.leetcode;

import com.yzy.common.TreeNode;

/**
 * Description:
 给定一个二叉树，找出其最小深度。

 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

 说明: 叶子节点是指没有子节点的节点。

 示例:

 给定二叉树 [3,9,20,null,null,15,7],

        3
      / \
    9   20
        /  \
        15   7
 返回它的最小深度  2.

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode111 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(4);
        TreeNode root6 = new TreeNode(3);
        root.left = root1;
        root.right = root2;

        //root1.left = root3;
        //root1.right = root4;

        root2.left = root5;
        //root2.right = root6;

        int head = solution(root);
        System.out.println(head);
    }

    public static int solution(TreeNode root) {
        return depth(root);
    }

    //求树的深度
    public static int depth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return depth(root.right) + 1;
        if (root.right == null) return depth(root.left) + 1;
        return Math.min(depth(root.left), depth(root.right)) + 1;
    }


}
