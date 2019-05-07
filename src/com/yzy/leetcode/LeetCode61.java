package com.yzy.leetcode;

import com.yzy.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

 示例 1:

 输入: 1->2->3->4->5->NULL, k = 2
 输出: 4->5->1->2->3->NULL
 解释:
 向右旋转 1 步: 5->1->2->3->4->NULL
 向右旋转 2 步: 4->5->1->2->3->NULL
 示例 2:

 输入: 0->1->2->NULL, k = 4
 输出: 2->0->1->NULL
 解释:
 向右旋转 1 步: 2->0->1->NULL
 向右旋转 2 步: 1->2->0->NULL
 向右旋转 3 步: 0->1->2->NULL
 向右旋转 4 步: 2->0->1->NULL
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode61 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        //head = solution(head, 4);
        head = solution(head, 2);
        System.out.println(head);
    }

    public static ListNode solution(ListNode head, int k) {
        if (head == null) return head;
        List<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p);
            p = p.next;
        }
        int n = k % list.size();
        if (n == 0) return head;

        head = list.get(list.size() - n); //旋转后的链表头是在list.size() - n的索引位置上
        p = head;
        for (int i = 1; i < list.size(); i++) { //依次将后续的元素放到接到链表尾部
            p.next = list.get((list.size() - n + i) % list.size());   //计算下标
            p = p.next;
        }
        p.next = null;  //将最后一个节点的next置空，避免出现闭环

        return head;
    }

    //solution 的优化版
    public static ListNode solution2(ListNode head, int k) {
        if (head == null) return head;
        List<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p);
            p = p.next;
        }
        int n = k % list.size();
        if (n == 0) return head;

        head = list.get(list.size() - n); //旋转后的链表头是在list.size() - n的索引位置上
        list.get(list.size() - 1).next = list.get(0);  //将原先的头接到原先的尾部，形成闭环
        list.get(list.size() - n - 1).next = null;  //解除闭环

        return head;
    }

    //快慢指针法 快指针比满指针快 k % head.length 个步长
    public static ListNode solution3(ListNode head, int k) {
        if (head == null) return head;
        ListNode node = head;
        int len = 1;
        while ((node = node.next) != null) len++;
        k %= len;
        int i = 0;
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (k > 0) {
            fastNode = fastNode.next;
            k--;
        }
        while (fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        fastNode.next = head;
        head = slowNode.next;
        slowNode.next = null;
        return head;
    }

}
