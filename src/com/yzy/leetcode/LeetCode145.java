package com.yzy.leetcode;

import com.yzy.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 给定一个二叉树，返回它的 后序 遍历。

 示例:

 输入: [1,null,2,3]
 1
 \
 2
 /
 3

 输出: [3,2,1]
 进阶: 递归算法很简单，你可以通过迭代算法完成吗


 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode145 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(7);

        List<Integer> head = solution(root);
        System.out.println(head);
    }

    public static List<Integer> solution(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        parse(root, list);
        return list;
    }

    //递归
    private static void parse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        parse(root.left, list);
        parse(root.right, list);
        list.add(root.val);
    }

    //迭代
    private static void parse2(TreeNode root, List<Integer> list) {

    }


}
