package com.yzy.leetcode;

import com.yzy.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

 说明:
 1 ≤ m ≤ n ≤ 链表长度。

 示例:

 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 输出: 1->4->3->2->5->NULL

 解题思想：提前记录翻转区域的前一个节点和后一个节点，然后把翻转区域提取出来单独处理

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode92 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        //node2.next = node3;
        //node3.next = node4;
        //node4.next = node5;

        head = solution(head, 1, 1);
        System.out.println(head);
    }

    public static ListNode solution(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode p = new ListNode(-1);
        p.next = head;
        head = p;
        List<ListNode> list = new ArrayList<>();
        while (p != null) {
            list.add(p);
            p = p.next;
        }
        if (m == n) return head.next;
        ListNode mPre = list.get(m - 1); //待翻转的前一个元素
        ListNode mLast = list.get(n).next;    //待翻转的后一个元素

        //翻转
        for (int i = n; i > m; i--) {
            list.get(i).next = list.get(i - 1);
        }

        mPre.next = list.get(n);
        list.get(m).next = mLast;

        return head.next;
    }


}
