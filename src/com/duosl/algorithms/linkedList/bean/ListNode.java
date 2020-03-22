package com.duosl.algorithms.linkedList.bean;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode newInstance(int[] x) {
        return new ListNode(x, 0);
    }

    private ListNode(int[] x, int index) {
        if (index < x.length) {
            val = x[index];
        }
        if (index < x.length - 1) {
            next = new ListNode(x, index + 1);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder(String.valueOf(val));
        ListNode tempNext = next;
        while (tempNext != null) {
            stringBuffer.append(" ").append(tempNext.val);
            tempNext = tempNext.next;
        }
        return stringBuffer.toString();
    }

    public void print(){
        System.out.println(this);
    }
}
