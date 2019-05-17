package com.yzy.leetcode;

import com.yzy.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

 示例:

 给定有序数组: [-10,-3,0,5,9],

 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

 0
 / \
 -3   9
 /   /
 -10  5

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode108 {

    public static void main(String[] args) {
        int[] root = new int[]{-10,-3,0,5,9};

        TreeNode res = solution(root);
        System.out.println(res);
    }

    public static TreeNode solution(int[] nums) {
        // 左右等分建立左右子树，中间节点作为子树根节点，递归该过程
        return nums == null ? null : buildTree(nums, 0, nums.length - 1);
    }

    private static TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        //求中点不要用 int mid = (l + r)/2，有溢出风险，稳妥的方法是 int mid = l + (r-l)/2
        //除以2改为右移1位更好 需要注意 右移运算符 优先级 最低，需要加括号
        int m = l + ((r - l) >> 1);
        TreeNode root = new TreeNode(nums[m]);
        root.left = buildTree(nums, l, m - 1);
        root.right = buildTree(nums, m + 1, r);
        return root;
    }

}
