package com.yzy.leetcode;

import com.yzy.common.ListNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 给定一个链表（链表结点包含一个整型值）的头结点 head。

 同时给定列表 G，该列表是上述链表中整型值的一个子集。

 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。

 示例 1：

 输入:
 head: 0->1->2->3
 G = [0, 1, 3]
 输出: 2
 解释:
 链表中,0 和 1 是相连接的，且 G 中不包含 2，所以 [0, 1] 是 G 的一个组件，同理 [3] 也是一个组件，故返回 2。
 示例 2：

 输入:
 head: 0->1->2->3->4
 G = [0, 3, 1, 4]
 输出: 2
 解释:
 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
 注意:

 如果 N 是给定链表 head 的长度，1 <= N <= 10000。
 链表中每个结点的值所在范围为 [0, N - 1]。
 1 <= G.length <= 10000
 G 是链表中所有结点的值的一个子集.


 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode817 {

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
        int[] G = new int[] {3,4,5,6};
        int head = solution(nodeA, G);
        System.out.println(head);

    }

    public static int solution(ListNode head, int[] G) {
        List list = Arrays.stream(G).boxed().collect(Collectors.toList());

        int max = 0;
        int num = 0;
        while (head != null) {
            if (list.contains(head.val)) {
                num++;
                max = max > num ? max : num;
            } else {
                max = max > num ? max : num;
                num = 0;
            }
            head = head.next;
        }

        return max;
    }


}
