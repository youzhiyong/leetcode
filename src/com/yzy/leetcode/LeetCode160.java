package com.yzy.leetcode;


import com.yzy.common.ListNode;

/**
 * Description:
 编写一个程序，找到两个单链表相交的起始节点。

 如下面的两个链表：



 在节点 c1 开始相交。



 示例 1：



 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 输出：Reference of the node with value = 8
 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。


 示例 2：



 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 输出：Reference of the node with value = 2
 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。


 示例 3：



 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 输出：null
 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 解释：这两个链表不相交，因此返回 null。


 注意：

 如果两个链表没有交点，返回 null.
 在返回结果后，两个链表仍须保持原有的结构。
 可假定整个链表结构中没有循环。
 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode160 {

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

        ListNode headA = new ListNode(1);
        headA.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode res = solution(head, headA);
        System.out.println(res);
    }

    /**
     * 思路：遍历两个链表到尾部，并记录两个链表的长度，若相交，则最后一个元素必定相同，
     * 然后将两个链表尾部对齐，减掉前面多余的头(两个链表长度相减)，然后再从离尾部相同长度的位置开始往后遍历并判断节点是否相等，第一个相等的节点即为交点
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode solution(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA;
        ListNode pB = headB;
        int lenA = 1;
        int lenB = 1;
        while (pA.next != null) {
            pA = pA.next;
            lenA++;
        }
        while (pB.next != null) {
            pB = pB.next;
            lenB++;
        }
        if (pA != pB) return null;//若相交，则最后一个节点必定相同

        pA = headA;
        pB = headB;
        if (lenA > lenB) {
            while (lenA != lenB) {
                pA = pA.next;
                lenA--;
            }
        } else if (lenA < lenB) {
            while (lenA != lenB) {
                pB = pB.next;
                lenB--;
            }
        }
        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
        }
        return pA;
    }

}
