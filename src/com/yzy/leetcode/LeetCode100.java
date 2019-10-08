package com.yzy.leetcode;

import com.yzy.common.TreeNode;

/**
 * Description:
 给定两个二叉树，编写一个函数来检验它们是否相同。

 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

 示例 1:

 输入:       1         1
 / \       / \
 2   3     2   3

 [1,2,3],   [1,2,3]

 输出: true
 示例 2:

 输入:      1          1
 /           \
 2             2

 [1,2],     [1,null,2]

 输出: false
 示例 3:

 输入:       1         1
 / \       / \
 2   1     1   2

 [1,2,1],   [1,1,2]

 输出: false

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode100 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        root.left = root1;

        root.right = root2;


        TreeNode aroot = new TreeNode(1);
        TreeNode aroot1 = new TreeNode(2);
        TreeNode aroot2 = new TreeNode(3);
        aroot.left = aroot1;

        //aroot.right = aroot2;

        boolean head = solution(root, aroot);
        System.out.println(head);
    }

    public static boolean solution(TreeNode p, TreeNode q) {
        return equal2(p ,q);
    }

    public static boolean equal(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (q == null) {
            return false;
        } else if (p == null) {
            return false;
        } else if (p.val == q.val) {
            return equal(p.left, q.left) && equal(p.right, q.right);
        } else {  //p.val != q.val
            return false;
        }
    }

    //代码精简
    public static boolean equal2(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (q == null) return false;
        else if (p == null) return false;
        else return p.val == q.val && equal2(p.left, q.left) && equal2(p.right, q.right);
    }


}
