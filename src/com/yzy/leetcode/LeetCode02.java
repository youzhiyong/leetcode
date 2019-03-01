package com.yzy.leetcode;

import com.yzy.common.ListNode;

/**
 * Description:
 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode02 {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        head.next = node2;
        node2.next = node3;

        ListNode head1 = new ListNode(5);
        ListNode node12 = new ListNode(6);
        ListNode node13 = new ListNode(4);
        head1.next = node12;
        node12.next = node13;

        ListNode res = solution(head, head1);
        System.out.println(res);
    }

    public static ListNode solution(ListNode l1, ListNode l2) {
        int n = 0;
        ListNode first = null;
        ListNode last = null;
        while (l1 != null || l2 != null || n != 0) {
            int sum = n;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode node = new ListNode(sum % 10);
            n = sum / 10;
            if (first == null) {
                first = node;
            } else if (last == null){
                last = node;
                first.next = last;
            } else {
                last.next = node;
                last = last.next;
            }
        }
        return first;
    }
}
