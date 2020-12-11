package mine.leetcode.add_two_numbers;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sim
 * Date: 2020-12-10
 * Time: 6:05 下午
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal/10;

            ListNode sumNode = new ListNode(sumVal%10);
            cursor.next = sumNode;
            cursor = sumNode;

            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode cursor1 = l1;
        cursor1.next = new ListNode(4);
        cursor1 = cursor1.next;
        cursor1.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        ListNode cursor2 = l2;
        cursor2.next = new ListNode(6);
        cursor2 = cursor2.next;
        cursor2.next = new ListNode(4);

        ListNode result = new Solution().addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

}
