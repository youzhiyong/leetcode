package com.yzy.leetcode;

import com.yzy.common.Node;
import com.yzy.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 给定一个 N 叉树，返回其节点值的后序遍历。

 例如，给定一个 3叉树 :

  



  

 返回其后序遍历: [5,6,3,2,4,1].

  

 说明: 递归法很简单，你可以使用迭代法完成此题吗?

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode590 {

    public static void main(String[] args) {

        List<Node> ch_1 = new ArrayList<>();
        ch_1.add(new Node(1));
        ch_1.add(new Node(2));

        List<Node> ch_2 = new ArrayList<>();
        ch_2.add(new Node(4));
        ch_2.add(new Node(5));

        ch_1.add(new Node(3, ch_2));

        Node root = new Node(8, ch_1);



        List<Integer> head = solution(root);
        System.out.println(head);
    }

    public static List<Integer> solution(Node root) {
        List<Integer> list = new ArrayList<>();
        parse(root, list);
        return list;
    }

    public static void parse(Node root, List<Integer> list) {
        if (root == null) return;
        if (root.children != null) {
            for (Node node : root.children) {
                parse(node, list);
            }
        }
        list.add(root.val);
    }


}
