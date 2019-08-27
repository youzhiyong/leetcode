package com.yzy.leetcode;

import com.yzy.common.ListNode;
import com.yzy.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 给定一个二叉树，检查它是否是镜像对称的。

 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

 1
 / \
 2   2
 / \ / \
 3  4 4  3


 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

 1
 / \
 2   2
 \   \
 3    3
 说明:

 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode101 {

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

        root1.left = root3;
        root1.right = root4;

        root2.left = root5;
        root2.right = root6;

        boolean head = solution2(root);
        System.out.println(head);
    }

    //递归
    public static boolean solution(TreeNode root) {
        return root == null || equal(root.right, root.left);
    }

    public static boolean equal(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (q == null) return false;
        else if (p == null) return false;
        else return p.val == q.val && equal(p.left, q.right) && equal(p.right, q.left);
    }

    //迭代  思路：一层一层的判断
    public static boolean solution2(TreeNode root) {
        if (root == null) return true;
        List<TreeNode> roots = new ArrayList<>();
        roots.add(root.left);
        roots.add(root.right);
        List<TreeNode> newRoots = new ArrayList<>();
        while (true) {
            int size = roots.size();
            for (int i = 0; i < roots.size() / 2; i++) {
                TreeNode left = roots.get(i);
                TreeNode right = roots.get(size - 1- i);
                if (left == null && right == null) continue;
                else if (right == null) return false;
                else if (left == null) return false;
                else if (left.val != right.val) return  false;
            }
            for (TreeNode node : roots) {
                if (node == null) continue;
                newRoots.add(node.left);
                newRoots.add(node.right);
            }
            if (newRoots.size() == 0) return true;
            roots.clear();
            roots.addAll(newRoots);
            newRoots.clear();
        }
    }


}
