package com.yzy.leetcode;

import com.yzy.common.TreeNode;

/**
 * Description:
 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]





 示例 1:

 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 输出: 3
 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 示例 2:

 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 输出: 5
 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。


 说明:

 所有节点的值都是唯一的。
 p、q 为不同节点且均存在于给定的二叉树中。

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode236 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(5);
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(6);
        TreeNode root4 = new TreeNode(2);
        TreeNode root5 = new TreeNode(0);
        TreeNode root6 = new TreeNode(8);
        TreeNode root7 = new TreeNode(7);
        TreeNode root8 = new TreeNode(4);
        root.left = root1;
        root.right = root2;

        root1.left = root3;
        root1.right = root4;

        root4.left = root7;
        root4.right = root8;

        root2.right = root6;
        root2.left = root5;

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        TreeNode exist = solution(root, p, q);
        System.out.println(exist);

    }

    public static TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;

        TreeNode left = solution(root.left, p, q);
        TreeNode right = solution(root.right, p, q);
        if (right == null && left == null) return null;
        if (right == null) return left;
        if (left == null) return right;
        return root;
    }




}
