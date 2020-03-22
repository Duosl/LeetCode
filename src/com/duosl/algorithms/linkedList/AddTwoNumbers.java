package com.duosl.algorithms.linkedList;

import com.duosl.algorithms.linkedList.bean.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 *
 * @author duoshilin
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = ListNode.newInstance(new int[]{2, 4, 8});
        ListNode l2 = ListNode.newInstance(new int[]{5, 6, 4});
        addTwoNumber(l1, l2).print();

    }

    private static ListNode addTwoNumber(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        int addOne = 0;
        while (l1 != null || l2 != null || addOne != 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + addOne;
            temp.next = new ListNode(sum % 10);
            addOne = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            temp = temp.next;
        }
        return dummyNode.next;
    }


}

