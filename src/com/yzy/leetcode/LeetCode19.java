package com.yzy.leetcode;

import com.yzy.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

 示例：

 给定一个链表: 1->2->3->4->5, 和 n = 2.

 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 说明：

 给定的 n 保证是有效的。

 进阶：

 你能尝试使用一趟扫描实现吗？
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode19 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        head = solution(head, 4);
        System.out.println(head);
    }

    public static ListNode solution(ListNode head, int n) {
        List<ListNode> listNodes = new ArrayList<>();
        ListNode next = head;
        while (next != null){
            listNodes.add(next);
            next = next.next;
        }
        int len = listNodes.size();
        if (n == len) return head.next;
        ListNode item= listNodes.get(len - n -1);
        item.next = item.next.next;
        return head;
    }

}
