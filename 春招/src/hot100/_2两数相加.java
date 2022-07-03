package hot100;

public class _2两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode l3 = new ListNode();
        ListNode head1 = l1, head2 = l2, head3 = l3;

        int carry = 0;
        int mod = 0;
        int sum = 0;
        while (head1 != null || head2 != null) {
            if (head1 != null && head2 != null) {
                sum = head1.val + head2.val + carry;
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1 != null) {
                sum = head1.val + carry;
                head1 = head1.next;
            } else if (head2 != null) {
                sum = head2.val + carry;
                head2 = head2.next;
            }

            carry = sum / 10;
            mod = sum % 10;

            l3.next = new ListNode(mod);
            l3 = l3.next;
        }
        if (sum >= 10) {
            l3.next = new ListNode(carry);
        }
        return head3.next;
    }
}
