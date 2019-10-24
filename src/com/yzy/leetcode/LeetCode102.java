package com.yzy.leetcode;

import com.yzy.common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

 例如:
 给定二叉树: [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回其层次遍历结果：

 [
 [3],
 [9,20],
 [15,7]
 ]

 * Date: 2019-02-27
 *
 * @see LeetCode429
 * @author youzhiyong
 */
public class LeetCode102 {

    public static void main(String[] args) {

        List<Node> ch_1 = new ArrayList<>();
        ch_1.add(new Node(1));
        ch_1.add(new Node(2));

        List<Node> ch_2 = new ArrayList<>();
        ch_2.add(new Node(4));
        ch_2.add(new Node(5));

        ch_1.add(new Node(3, ch_2));

        Node root = new Node(8, ch_1);



        List<List<Integer>> head = solution(root);
        System.out.println(head);
    }

    public static List<List<Integer>> solution(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Node> line = new ArrayList<>();
        line.add(root);
        while (line.size() > 0) {
         List<Integer> vals = new ArrayList<>();
         List<Node> nextLine = new ArrayList<>();
         for (Node node : line) {
             vals.add(node.val);
             if (node.children != null) nextLine.addAll(node.children);
         }

         res.add(vals);
         line = nextLine;
        }
        return res;
    }


}
