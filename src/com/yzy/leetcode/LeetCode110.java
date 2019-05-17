package com.yzy.leetcode;

import com.yzy.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 给定一个二叉树，判断它是否是高度平衡的二叉树。

 本题中，一棵高度平衡二叉树定义为：

 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

 示例 1:

 给定二叉树 [3,9,20,null,null,15,7]

 3
 / \
 9  20
 /  \
 15   7
 返回 true 。

 示例 2:

 给定二叉树 [1,2,2,3,3,null,null,4,4]

 1
 / \
 2   2
 / \
 3   3
 / \
 4   4
 返回 false 。

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode110 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(4);
        TreeNode root6 = new TreeNode(3);
        //root.left = root1;
        root.right = root2;

        root1.left = root3;
        root1.right = root4;

        root2.left = root5;
        //root2.right = root6;

        boolean head = solution(root);
        System.out.println(head);
    }


    public static boolean solution(TreeNode root) {
        return isBalance(root);
    }

    //递归
    // 方案1. 先判断左右子树高度差 再判断左右子树是否平衡
    // 方案2. 先判断左右子树是否平衡 再判断左右子树高度差
    // 方案1 用时2ms, 方案2快用时4ms
    public static boolean isBalance(TreeNode root) {
        return root == null || (Math.abs(depth(root.left) - depth(root.right)) <= 1) && isBalance(root.left) && isBalance(root.right);
    }

    //求树的深度
    public static int depth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }


}
