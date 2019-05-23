package leetcode;

public class SplitLinkedListinParts {
    /**
     * https://leetcode.com/problems/split-linked-list-in-parts/description/
     * 725. Split Linked List in Parts
     * @param root
     * @param k
     * @return
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        int N = 0;
        ListNode cur = root;
        while (cur != null) {
            N ++;
            cur = cur.next;
        }
        int mod = N % k;
        int size = N / k;

        ListNode[] ret = new ListNode[k];
        cur = root;

        for (int i = 0; cur != null && i < k; i ++) {
            ret[i] = cur;
            int curSize = size + (mod -- > 0 ? 1 : 0);
            for (int j = 0; j < curSize - 1; j++) {
                cur = cur.next;
            }
            //备份
            ListNode next = cur.next;
            //断链
            cur.next = null;
            //新起点
            cur = next;
        }
        return ret;
    }
}
