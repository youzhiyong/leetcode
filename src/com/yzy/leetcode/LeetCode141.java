package com.yzy.leetcode;


import com.yzy.common.ListNode;

/**
 * Description:
 给定一个链表，判断链表中是否有环。

 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。



 示例 1：

 输入：head = [3,2,0,-4], pos = 1
 输出：true
 解释：链表中有一个环，其尾部连接到第二个节点。


 示例 2：

 输入：head = [1,2], pos = 0
 输出：true
 解释：链表中有一个环，其尾部连接到第一个节点。


 示例 3：

 输入：head = [1], pos = -1
 输出：false
 解释：链表中没有环。




 进阶：

 你能用 O(1)（即，常量）内存解决此问题吗？
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode141 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;

        boolean res = solution(head);
        System.out.println(res);
    }

    //使用快慢指针,如果没有环，则快指针会最先达到终点，若有环，则快指针最终会与慢指针相遇
    public static boolean solution(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode firstNode = head;
        ListNode slowNode = head;
        while (firstNode != null && firstNode.next != null) {

            if (firstNode.next.next == slowNode.next) {
                return true;
            }
            firstNode = firstNode.next.next;
            slowNode = slowNode.next;
        }
        return false;
    }


}
