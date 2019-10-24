package com.yzy.leetcode;

import com.yzy.common.ListNode;

/**
 * Description:
 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。

 在链表类中实现这些功能：

 get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
  

 示例：

 MyLinkedList linkedList = new MyLinkedList();
 linkedList.addAtHead(1);
 linkedList.addAtTail(3);
 linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 linkedList.get(1);            //返回2
 linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 linkedList.get(1);            //返回3
  

 提示：

 所有val值都在 [1, 1000] 之内。
 操作次数将在  [1, 1000] 之内。
 请不要使用内置的 LinkedList 库。

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode707 {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        /*linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);            //返回3*/

       /* ["MyLinkedList","addAtHead","addAtIndex","addAtIndex","addAtTail","addAtHead","addAtIndex","addAtIndex","addAtIndex","addAtTail","addAtTail","deleteAtIndex"]
[[],[0],[1,9],[1,5],[7],[1],[5,8],[5,2],[3,0],[1],[0],[6]]*/
        /*linkedList.addAtHead(0);
        linkedList.addAtIndex(1,9);
        linkedList.addAtIndex(1,5);
        linkedList.addAtTail(7);
        linkedList.addAtHead(1);
        linkedList.addAtIndex(5,8);
        linkedList.addAtIndex(5,2);
        linkedList.addAtIndex(3,0);
        linkedList.addAtTail(1);
        linkedList.addAtTail(0);
        linkedList.deleteAtIndex(6);
        linkedList.get(1);
        linkedList.get(5);*/

/*            ["MyLinkedList","addAtHead","deleteAtIndex"]
    [[],[1],[0]]*/
        linkedList.addAtTail(1);
        linkedList.deleteAtIndex(0);
    }

    static class MyLinkedList {

        static class ListNode {
            public int val;
            public ListNode pre;
            public ListNode next;
            public ListNode(int x) { val = x; }
        }

        private ListNode head;  //头节点
        private ListNode tail;  //尾结点
        private int len;        //链表长度


        /** Initialize your data structure here. */
        public MyLinkedList() {
            head = null;
            tail = null;
            len = 0;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            ListNode node = getNode(index);
            return node == null ? -1 : node.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            ListNode newNode = new ListNode(val);
            if (len == 0) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.pre = newNode;
                head = newNode;
            }
            len++;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            ListNode newNode = new ListNode(val);
            if (len == 0) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.pre = tail;
                tail.next = newNode;
                tail = newNode;
            }
            len++;
        }
        

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            ListNode newNode = new ListNode(val);
            if (index <= 0) {
                //添加在头部
                addAtHead(val);
            } else if (index == len) {
                //添加在尾部
                addAtTail(val);
            } else if (len > index) {
                ListNode temp = getNode(index);
                ListNode preTemp = temp.pre;
                preTemp.next = newNode;
                newNode.pre = preTemp;
                newNode.next = temp;
                temp.pre = newNode;
                len++;
            } else {
                // index > len  不处理
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= len) return;
            if (index == 0) {
                //删除头节点
                head = head.next;
                if (head != null) head.pre = null;
            } else if (index == len - 1) {
                //删除尾节点
                tail = tail.pre;
                if (tail != null) tail.next = null;
            } else {
                //删除中间节点
                ListNode temp = getNode(index);
                temp.pre.next = temp.next;
                temp.next.pre = temp.pre;
            }
            len--;
        }

        private ListNode getNode(int index) {
            //链表为空 或者 索引非法
            int iLen = len;
            if (iLen == 0 || index >= iLen || index < 0) return null;
            if (index == 0) return head;
            if (index == iLen - 1) return tail;

            ListNode node = null;
            if (index <= iLen / 2) {
                //从前向后查找
                int i = 0;
                node = head;
                while (i < index) {
                    node = node.next;
                    i++;
                }
            } else {
                //从后向前查找
                int i = len - 1;
                node = tail;
                while (i > index) {
                    node = node.pre;
                    i--;
                }
            }
            return node;
        }
    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */


}
