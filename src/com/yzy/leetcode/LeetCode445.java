package com.yzy.leetcode;

import com.yzy.common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description:
 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。

  

 你可以假设除了数字 0 之外，这两个数字都不会以零开头。

 进阶:

 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。

 示例:

 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出: 7 -> 8 -> 0 -> 7

 * @see LeetCode191
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode445 {

    public static void main(String[] args) {
        ListNode nodeA = new ListNode(3);
        ListNode nodeB = new ListNode(7);

        nodeA.next = new ListNode(9);
        nodeA.next.next = new ListNode(9);
        nodeA.next.next.next = new ListNode(9);
        nodeA.next.next.next.next = new ListNode(9);
        nodeA.next.next.next.next.next = new ListNode(9);
        nodeA.next.next.next.next.next.next = new ListNode(9);
        nodeA.next.next.next.next.next.next.next = new ListNode(9);
        nodeA.next.next.next.next.next.next.next.next = new ListNode(9);
        nodeA.next.next.next.next.next.next.next.next.next = new ListNode(9);
        ListNode head = solution3(nodeA, nodeB);
        System.out.println(head);

    }

    //  long 以上的数据会失败
    public static ListNode solution(ListNode l1, ListNode l2) {
        long numA = 0;
        long numB = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                numA = numA * 10 + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                numB = numB * 10 + l2.val;
                l2 = l2.next;
            }
        }

        long sum = numA + numB;
        ListNode head = new ListNode(0);
        if (sum == 0) return head;

        while (sum != 0) {
            int val = (int) (sum % 10);
            ListNode next = head.next;
            head.next = new ListNode(val);
            head.next.next = next;
            sum /= 10;
        }

        return head.next;
    }

    //使用栈来存节点数据
    public static ListNode solution2(ListNode l1, ListNode l2) {
        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();

        while (l1 != null || l2 != null) {

            if (l1 != null) {
                stackA.push(l1.val);
                l1 = l1.next;
            }

            if (l2 != null) {
                stackB.push(l2.val);
                l2 = l2.next;
            }
        }

        boolean flag = false;
        ListNode head = new ListNode(0);

        while (!stackA.isEmpty() || !stackB.isEmpty() || flag) {
            int sum = flag ? 1 : 0;
            sum += stackA.isEmpty() ? 0 : stackA.pop();
            sum += stackB.isEmpty() ? 0 : stackB.pop();

            if (sum >= 10) {
                flag = true;
                sum -= 10;
            } else {
                flag = false;
            }

            ListNode next = head.next;
            head.next = new ListNode(sum);
            head.next.next = next;
        }

        return head.next;
    }

    /**
     * 利用递归的回溯特性  最优
     * 执行用时 :5 ms, 在所有 Java 提交中击败了98.90%的用户内存消耗 :43.1 MB, 在所有 Java 提交中击败了90.88%的用户
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode solution3(ListNode l1, ListNode l2) {

        //计算链表长度
        int lenA = calcLen(l1);
        int lenB = calcLen(l2);

        //补齐链表长度
        if (lenA > lenB) {
            while (lenA > lenB) {
                ListNode node = new ListNode(0);
                node.next = l2;
                l2 = node;
                lenB++;
            }
        } else {
            while (lenA < lenB) {
                ListNode node = new ListNode(0);
                node.next = l1;
                l1 = node;
                lenA++;
            }
        }

        ListNode head = new ListNode(0);
        int flag = addList(l1, l2, head);

        //最后有进位的话，头部需要补一个节点1
        if (flag == 1) {
            ListNode next = head.next;
            head.next = new ListNode(1);
            head.next.next = next;
        }

        return head.next;
    }

    //递归计算长度
    private static int calcLen(ListNode listNode) {
        if (listNode == null) return 0;
        return 1 + calcLen(listNode.next);
    }

    //递归相加 两个链表
    private static int addList(ListNode l1, ListNode l2, ListNode head) {
        if (l1 == null || l2 == null) return 0;  // l1 和 l2的长度相等
        int sum = l1.val + l2.val + addList(l1.next, l2.next, head);
        ListNode node = new ListNode(sum % 10);
        ListNode next = head.next;
        node.next = l1.next == null ? null : next;  // 最后一个节点的next为null
        head.next = node;
        return sum / 10;
    }

}
