package 剑指offer;

/**
 * 多数投票问题，可以利用 Boyer-Moore Majority Vote Algorithm 来解决这个问题，使得时间复杂度为 O (N)。
 *
 * 使用 cnt 来统计一个元素出现的次数，当遍历到的元素和统计元素相等时，令 cnt++，否则令 cnt--。如果前面查找了 i 个元素，且 cnt == 0，
 * 说明前 i 个元素没有 majority，或者有 majority，但是出现的次数少于 i / 2 ，因为如果多于 i / 2 的话 cnt 就一定不会为 0 。
 * 此时剩下的 n - i 个元素中，majority 的数目依然多于 (n - i) / 2，因此继续查找就能找出 majority。
 */
public class 数组中出现次数超过一半的数字 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int majority = array[0];
        int cnt = 1;
        for (int i = 1; i < array.length; i++) {
            cnt = array[i] == majority ? cnt + 1 : cnt - 1;
            if (cnt == 0) {
                // 重新选一个majority
                // 重头再来
                majority = array[i];
                cnt = 1;
            }
        }
        // 重新测一下
        // 因为这个算法机制 可能会使cnt的值最终不能达到大于一半
        // 算法思想挺有意思的
        cnt = 0;
        for (int val : array) {
            if (val == majority) {
                cnt++;
            }
        }

        return cnt > array.length / 2 ? majority : 0;
    }
}
