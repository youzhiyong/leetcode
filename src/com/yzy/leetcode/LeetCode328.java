package com.yzy.leetcode;

import com.yzy.common.ListNode;

import java.util.Stack;

/**
 * Description:
 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

 示例 1:

 输入: 1->2->3->4->5->NULL
 输出: 1->3->5->2->4->NULL
 示例 2:

 输入: 2->1->3->5->6->4->7->NULL
 输出: 2->3->6->7->1->5->4->NULL


 * @see LeetCode191
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode328 {

    public static void main(String[] args) {
        ListNode nodeA = new ListNode(3);

        nodeA.next = new ListNode(4);
        nodeA.next.next = new ListNode(5);
        nodeA.next.next.next = new ListNode(6);
        nodeA.next.next.next.next = new ListNode(7);
        nodeA.next.next.next.next.next = new ListNode(8);
        nodeA.next.next.next.next.next.next = new ListNode(9);
        nodeA.next.next.next.next.next.next.next = new ListNode(10);
        nodeA.next.next.next.next.next.next.next.next = new ListNode(11);
        nodeA.next.next.next.next.next.next.next.next.next = new ListNode(12);
        ListNode head = solution(nodeA);
        System.out.println(head);
    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了98.53%的用户
     * @param head
     * @return
     */
    public static ListNode solution(ListNode head) {
        ListNode listNodeA = new ListNode(0);  //存放奇数节点
        ListNode listNodeB = new ListNode(0);  //存放偶数节点
        ListNode lastA = listNodeA; //指向 奇数节点 链表的尾部
        ListNode lastB = listNodeB; //指向 偶数节点 链表的尾部
        boolean flag = true; //控制奇偶  true表示奇数，false偶数
        while (head != null) {
            ListNode temp = head.next;
            head.next = null;
            if (flag) {  //奇数节点
                lastA.next = head;
                lastA = lastA.next;
                flag = false;
            } else {   //偶数节点
                lastB.next = head;
                lastB = lastB.next;
                flag = true;
            }
            head = temp;
        }
        lastA.next = listNodeB.next;
        return listNodeA.next;
    }

}
