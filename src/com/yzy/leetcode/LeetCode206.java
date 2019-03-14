package com.yzy.leetcode;

import com.yzy.common.ListNode;

/**
 * Description:
 反转一个单链表。

 示例:

 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL
 进阶:
 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

 定义                             优点                                              缺点

 递归  程序调用自身的编程技巧称为递归      1）大问题化为小问题,可以极大的减少代码量；      1）递归调用函数,浪费空间；
                                           2）用有限的语句来定义对象的无限集合.；          2）递归太深容易造成堆栈的溢出；
                                           3）代码更简洁清晰，可读性更好

 迭代 利用变量的原值推算出变量的一个新值， 1）迭代效率高，运行时间只因循环次数增加而增加； 1） 不容易理解；
      迭代就是A不停的调用B.                2）没什么额外开销，空间上也没有什么增加，       2） 代码不如递归简洁；
                                                                                           3） 编写复杂问题时困难。

 二者关系
 1） 递归中一定有迭代,但是迭代中不一定有递归,大部分可以相互转换。
 2） 能用迭代的不用递归,递归调用函数,浪费空间,并且递归太深容易造成堆栈的溢出.

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode206 {

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

        ListNode exist = solution(head);
        System.out.println(exist);

    }

    public static ListNode solution(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    //递归算法   迭代算法优于递归，能用迭代尽量用迭代
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


}
