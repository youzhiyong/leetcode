package com.yzy.leetcode;

import com.yzy.common.Node;
import com.yzy.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

 例如，给定一个 3叉树 :

  



  

 返回其层序遍历:

 [
 [1],
 [3,2,4],
 [5,6]
 ]
  

 说明:

 树的深度不会超过 1000。
 树的节点总数不会超过 5000。

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode429 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> head = solution(root);
        System.out.println(head);
    }

    public static List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<TreeNode> line = new ArrayList<>();
        line.add(root);
        while (line.size() > 0) {
         List<Integer> vals = new ArrayList<>();
         List<TreeNode> nextLine = new ArrayList<>();
         for (TreeNode node : line) {
             vals.add(node.val);
             if (node.left != null) nextLine.add(node.left);
             if (node.right != null) nextLine.add(node.right);
         }

         res.add(vals);
         line = nextLine;
        }
        return res;
    }


}
