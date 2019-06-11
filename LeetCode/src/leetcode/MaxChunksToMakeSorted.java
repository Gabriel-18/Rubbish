package leetcode;

public class MaxChunksToMakeSorted {
    /**
     * https://leetcode.com/problems/max-chunks-to-make-sorted/
     * 769. Max Chunks To Make Sorted
     * 找准什么时候可以排序
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int ret = 0;
        int right = arr[0];
        for (int i = 0; i < arr.length; i++) {
            right = Math.max(right, arr[i]);
            if (right == i) {
                ret ++;
            }
        }
        return ret;
    }
}
