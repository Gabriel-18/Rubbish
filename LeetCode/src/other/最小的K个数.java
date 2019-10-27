package other;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class 最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (k > input.length || k <= 0) {
            return ret;
        }
        findKthSmallest(input, k - 1);
        /* findKthSmallest 会改变数组，使得前 k 个数都是最小的 k 个数 */
        for (int i = 0; i < k; i++) {
            ret.add(input[i]);
        }
        return ret;
    }

    private void findKthSmallest(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            }
            if (j > k) {
                h = j - 1;
            } else {
                l = j + 1;
            }
        }
    }

    private int partition(int[] nums, int l, int h) {
        int p = nums[l];
        int i = l, j = h + 1;
        while (true) {
            while (i != h && nums[++i] < p) {
                ;
            }
            while (j != l && nums[--j] > p) {
                ;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, i, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        if (k > input.length || k <= 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : input) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }
}
