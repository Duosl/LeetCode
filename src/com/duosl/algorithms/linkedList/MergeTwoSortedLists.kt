package com.duosl.algorithms.linkedList

import com.duosl.algorithms.linkedList.bean.ListNode

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

fun main() {
    val l1 = ListNode.newInstance(intArrayOf(1, 2, 4))
    println("l1: $l1")
    val l2 = ListNode.newInstance(intArrayOf(1, 3, 4))
    println("l2: $l2")
    mergeTwoLists1(l1, l2)?.print()
    mergeTwoLists2(l1, l2)?.print()
}

/**
 * Method 1 loop
 */
fun mergeTwoLists1(l1: ListNode?, l2: ListNode?): ListNode? {
    // kotlin 不能对函数参数重新赋值？
    var ll1 = l1
    var ll2 = l2

    val preHead = ListNode(-1)
    val temp = preHead
    while (ll1 != null && ll2 != null) {
        if (ll1.`val` < ll2.`val`) {
            temp.next = ll1.next
            ll1 = ll1.next
        } else{
            temp.next = ll2.next
            ll2 = ll2.next
        }
    }
    temp.next = l1 ?: l2
    return preHead.next
}

/**
 * method 2 Recursive
 */
fun mergeTwoLists2(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) {
        return l2
    }
    if (l2 == null) {
        return l1
    }
    if (l1.`val` < l2.`val`) {
        l1.next = mergeTwoLists2(l1.next, l2)
        return l1
    } else {
        l2.next = mergeTwoLists2(l1, l2.next)
        return l2
    }
}
