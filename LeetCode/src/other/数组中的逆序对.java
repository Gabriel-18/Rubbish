package other;

public class 数组中的逆序对 {
    private int[] tmp;  // 在这里声明辅助数组，而不是在 merge() 递归函数中声明

    public int InversePairs(int[] nums) {
        tmp = new int[nums.length];
        long res = merge_sort(nums, 0, nums.length - 1);
        return (int) (res % 1000000007);
    }


    private long merge_sort(int[] nums, int l, int r) {
        if (l >= r) return 0;
        int mid = l + (r - l) / 2;
        long res = merge_sort(nums, l, mid) + merge_sort(nums, mid + 1, r);

        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if(nums[i] <= nums[j]) tmp[k++] = nums[i++];
            else {
                tmp[k++] = nums[j++];
                res += mid - i + 1;
            }
        }

        while (i <= mid) tmp[k++] = nums[i++];
        while (j <= r) tmp[k++] = nums[j++];

        for (int i1 = l, j1 = 0; i1 <= r ; i1++, j1++) {
            nums[i1] = tmp[j1];
        }
        return res;
    }

}
