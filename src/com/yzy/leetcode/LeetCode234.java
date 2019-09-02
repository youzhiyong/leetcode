package com.yzy.leetcode;

import com.yzy.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 请判断一个链表是否为回文链表。

 示例 1:

 输入: 1->2
 输出: false
 示例 2:

 输入: 1->2->2->1
 输出: true
 进阶：
 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode234 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        boolean res = solution3(head);
        System.out.println(res);

    }

    //比较慢
    public static boolean solution(ListNode head) {
        ListNode node = head;
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);

            node = node.next;
        }

        int len = list.size();
        for (int i = 0; i < len / 2; i++) {

            if (list.get(i).intValue() != list.get(len - 1 - i)) {
                return false;
            }

        }
        return true;
    }

    /**
     * 1. 快慢指针找中点
     * 2. 翻转前半部分链表
     * 3. 前后链表 判断回文
     * @param head
     * @return
     */
    public static boolean solution2(ListNode head) {

        if (head == null) return true;

        //1. 快慢指针找中点
        ListNode quickNode = head;
        ListNode slowNode = head;
        while (quickNode != null && quickNode.next != null) {
            quickNode = quickNode.next.next;
            slowNode = slowNode.next;
        }

        //2. 翻转前半部分链表
        ListNode newHead = new ListNode(slowNode.val);
        ListNode p = head;
        while (p != slowNode) {
            ListNode next = newHead.next;
            newHead.next = new ListNode(p.val);
            newHead.next.next = next;
            p = p.next;
        }

        //3. 注意，这里需要判断链表长度 是奇数还是偶数
        if (quickNode == null) {  //快指针为空，表示链表长度为偶数  需要处理！！！！   注意，这里可以画图验证
            newHead = newHead.next;   //去掉前半部分翻转后链表的第一个元素
        }

        //4. 判断两个链表是否为回文
        while (slowNode != null) {
            if (newHead.val != slowNode.val) return false;

            slowNode = slowNode.next;
            newHead = newHead.next;
        }
        return true;
    }

    public static boolean solution3(ListNode head) {
        if (head == null || head.next == null) return true;

        // 1. 快慢指针求中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. 翻转前部分链表
        ListNode pre = null;
        ListNode next = null;
        while (head != slow) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        //3. 处理奇偶链表
        if (fast != null) {
            slow = slow.next;
        }

        //4. 判断回文
        while (slow != null) {
            if (slow.val != pre.val) return false;
            slow = slow.next;
            pre = pre.next;
        }

        return true;

    }




}
