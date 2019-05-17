package com.yzy.leetcode;

import com.yzy.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

 例如：
 给定二叉树 [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回其自底向上的层次遍历为：

 [
 [15,7],
 [9,20],
 [3]
 ]

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode107 {

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

        List<List<Integer>> res = solution(root);
        System.out.println(res);
    }

    public static List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        List<TreeNode> roots = new ArrayList<>();
        roots.add(root);
        while (roots.size() > 0) {
            List<TreeNode> nextRoots = new ArrayList<>();
            List<Integer> rootsValue = new ArrayList<>();
            for (TreeNode node : roots) {
                rootsValue.add(node.val);
                if (node.left != null) nextRoots.add(node.left);
                if (node.right != null) nextRoots.add(node.right);
            }
            roots = nextRoots;
            lists.add(0, rootsValue);
        }

        return lists;
    }


}
