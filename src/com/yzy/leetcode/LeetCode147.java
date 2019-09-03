package com.yzy.leetcode;


import com.yzy.common.ListNode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description:
 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。

  

 插入排序算法：

 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 重复直到所有输入数据插入完为止。
  

 示例 1：

 输入: 4->2->1->3
 输出: 1->2->3->4
 示例 2：

 输入: -1->5->3->4->0
 输出: -1->0->3->4->5
 在真实的面试中遇到过这道题？

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode147 {

    public static void main(String[] args) {

        ListNode head = new ListNode(5);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode res = solution(head);
    }

    public static ListNode solution(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode p = head;
        head = head.next;
        p.next = null;
        while (head != null) {
            ListNode next = head;
            head = head.next;
            if (next.val <= p.val) {
                next.next = p;
                p = next;
            } else {
                ListNode pNext = p;
                ListNode pNextNext = pNext.next;
                while (pNextNext != null && next.val > pNextNext.val) {
                    pNext = pNextNext;
                    pNextNext = pNextNext.next;
                }
                next.next = pNextNext;
                pNext.next = next;
            }

        }
        return p;
    }


}
