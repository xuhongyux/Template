package com.xiayu.params.num1;

import com.xiayu.params.ListNode;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/10/20 13:50
 * <p>
 * 给出两个非空的链表用来表示两个非负整数。其中，
 * 他们各自的位数是按照逆序的方式存储，
 * 并且他们的每个节点只能存储一位数字。如果将这两个数相加，则回返回一个新
 * 的链表来表示他们的和
 * <p>
 * <p>
 * 对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head。
 * 使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
 */
public class TwoAdd_02 {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode = addTwoNumbers(listNode1, listNode2);
        //     System.out.println("");

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}
