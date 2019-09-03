package com.yzy.leetcode;

import com.yzy.common.ListNode;

/**
 * Description:
 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。

 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。

 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。

 返回一个符合上述规则的链表的列表。

 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]

 示例 1：

 输入:
 root = [1, 2, 3], k = 5
 输出: [[1],[2],[3],[],[]]
 解释:
 输入输出各部分都应该是链表，而不是数组。
 例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
 第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
 最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
 示例 2：

 输入:
 root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 解释:
 输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
  

 提示:

 root 的长度范围： [0, 1000].
 输入的每个节点的大小范围：[0, 999].
 k 的取值范围： [1, 50].
 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode725 {

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
        ListNode[] head = solution(nodeA, 11);
        System.out.println(head);

    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了96.89%的用户
     * 内存消耗 :37.3 MB, 在所有 Java 提交中击败了60.34%的用户
     */
    public static ListNode[] solution(ListNode root, int k) {
        int len = getLength(root);
        ListNode[] listNodes = new ListNode[k];
        if (len <= k) {
            for (int i = 0; root != null; i++) {
                ListNode next = root.next;
                root.next = null;
                listNodes[i] = root;
                root = next;
            }
        } else {
            int count = len / k;  //平均每个链表可以分多少
            int mod = len % k;    //剩余部分按照先后顺序依次分配一个
            for (int i = 0; i<k; i++) {
                int iLen = count + (mod-- > 0 ? 1 : 0);  //该部分链表的最终长度 = 平均长度(count) + 是否有剩余 ？ 有则再加1 : 无则不加     mod每次用了之后需要减1
                ListNode next = root;
                while (iLen > 1) {
                    next = next.next;
                    iLen--;
                }
                listNodes[i] = root;
                root = next.next;
                next.next = null;
            }
        }

        return listNodes;
    }

    private static int getLength(ListNode node) {
        if (node == null) return 0;
        return 1 + getLength(node.next);
    }


}
