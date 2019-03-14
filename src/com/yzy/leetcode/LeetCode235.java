package com.yzy.leetcode;

import com.yzy.common.TreeNode;

/**
 * Description:
 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]





 示例 1:

 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 输出: 6
 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 示例 2:

 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 输出: 2
 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。


 说明:

 所有节点的值都是唯一的。
 p、q 为不同节点且均存在于给定的二叉搜索树中。
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode235 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(6);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(8);
        TreeNode root3 = new TreeNode(0);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(7);
        TreeNode root6 = new TreeNode(9);
        TreeNode root7 = new TreeNode(3);
        TreeNode root8 = new TreeNode(5);
        root.left = root1;
        root1.left = root3;
        root1.right = root4;
        root4.left = root7;
        root4.right = root8;


        root.right = root2;
        root2.right = root6;
        root2.left = root5;

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);
        TreeNode exist = solution(root, p, q);
        System.out.println(exist);

    }

    public static TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {

        //二叉平衡树的特性： 中间节点大于左子树，小于右子树
        //1. p和q都小于当前根节点，则向左子树遍历
        //2. p和q都大于当前根节点，则向右子树遍历
        //3. 否则的情况，p和q在两侧或者有一个等于根节点 此时都返回当前节点

        if (root.val > p.val && root.val > q.val) return solution(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return solution(root.right, p, q);

        return root;
    }


}
