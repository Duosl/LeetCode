package com.duosl.algorithms.linkedList

import com.duosl.algorithms.linkedList.bean.ListNode

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

fun main() {
    val l1 = ListNode.newInstance(intArrayOf(2, 4, 8))
    val l2 = ListNode.newInstance(intArrayOf(5, 6, 4))
    addTwoNumbers(l1, l2)?.print()
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null && l2 == null) {
        return null
    }
    // kotlin 不能对函数参数重新赋值？
    var ll1 = l1
    var ll2 = l2

    val dummy = ListNode(-1)
    var temp = dummy
    var addOne = 0
    while (ll1 != null || ll2 != null || addOne != 0) {
        val val1 = ll1?.`val` ?: 0
        val val2 = ll2?.`val` ?: 0
        val sum = val1 + val2 + addOne
        temp.next = ListNode( sum % 10)
        temp = temp.next
        addOne = sum / 10
        ll1 = ll1?.next
        ll2 = ll2?.next
    }

    return dummy.next

}
