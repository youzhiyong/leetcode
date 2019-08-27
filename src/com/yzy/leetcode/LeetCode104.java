package com.yzy.leetcode;

import com.yzy.common.ListNode;
import com.yzy.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 给定一个二叉树，找出其最大深度。

 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

 说明: 叶子节点是指没有子节点的节点。

 示例：
 给定二叉树 [3,9,20,null,null,15,7]，

 3
 / \
 9  20
 /  \
 15   7
 返回它的最大深度 3 。

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode104 {

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

        int res = solution2(root);
        System.out.println(res);
    }

    //递归
    public static int solution(TreeNode root) {
        if (root == null) return 0;
        int left = solution(root.left);
        int right = solution(root.right);

        return (left > right ? left:right) + 1;
    }

    //迭代
    public static int solution2(TreeNode root) {
        if (root == null) return 0;
        int n = 0;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        List<TreeNode> newNodes = new ArrayList<>();
        while (nodes.size() > 0) {
            n++;
            for (TreeNode node : nodes) {
                if (node.left != null) newNodes.add(node.left);
                if (node.right != null) newNodes.add(node.right);
            }
            nodes.clear();
            nodes.addAll(newNodes);
            newNodes.clear();
        }

        return n;
    }


}
