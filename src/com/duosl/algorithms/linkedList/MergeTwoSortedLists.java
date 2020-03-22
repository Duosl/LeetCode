package com.duosl.algorithms.linkedList;


import com.duosl.algorithms.linkedList.bean.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 题目链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 *
 * @author duoshilin
 */
public class MergeTwoSortedLists {


    public static void main(String[] args) {
        ListNode l1 = ListNode.newInstance(new int[]{1, 2, 4});
        System.out.println("l1 : " + l1);

        ListNode l2 = ListNode.newInstance(new int[]{1, 3, 4});
        System.out.println("l2 : " + l2);

        mergeTwoLists1(l1, l2).print();
        //mergeTwoLists2(l1, l2).print();
    }

    /**
     * method1 Loop (遍历)
     */
    private static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode temp = preHead;
        while (l1 != null && l2 != null) {
            if (l2.val < l1.val) {
                temp.next = l2;
                l2 = l2.next;
            } else {
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    /**
     * method2 Recursive (递归)
     */
    private static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

}
