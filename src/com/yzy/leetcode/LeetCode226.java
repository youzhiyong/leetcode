package com.yzy.leetcode;

import com.yzy.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 翻转一棵二叉树。

 示例：

 输入：

           4
         /   \
        2     7
       / \   / \
      1   3 6   9
 输出：

          4
        /   \
       7     2
      / \   / \
     9   6 3   1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/invert-binary-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode226 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(7);
        TreeNode root3 = new TreeNode(1);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(6);
        TreeNode root6 = new TreeNode(9);
        root.left = root1;
        root1.left = root3;
        root1.right = root4;

        root.right = root2;
        root2.right = root6;
        root2.left = root5;

        TreeNode exist = solution(root);
        System.out.println(exist);

    }

    public static TreeNode solution(TreeNode root) {
        if (root == null) return root;
        if (root.left != null) solution(root.left);
        if (root.right!= null) solution(root.right);
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        return root;
    }


}
