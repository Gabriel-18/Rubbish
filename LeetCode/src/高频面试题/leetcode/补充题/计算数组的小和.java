package 高频面试题.leetcode.补充题;

import java.util.Scanner;

public class 计算数组的小和 {
    private static long merge_sort(int[] nums,int[] tmp, int l, int r) {
        if (l >= r) return 0;
        int mid = l + (r - l) / 2;
        long res = merge_sort(nums, tmp, l, mid) + merge_sort(nums,tmp,mid + 1, r);

        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if(nums[i] <= nums[j]) {
                res += (r - j + 1) * nums[i];
                tmp[k++] = nums[i++];

            } else {
                // nums[i] > nums[j]
                tmp[k++] = nums[j++];
                // 当前左边的元素都大于nums[j]
                //[l, mid] [mid + 1,  r]

            }
        }

        while (i <= mid) tmp[k++] = nums[i++];
        while (j <= r) tmp[k++] = nums[j++];

        for (int i1 = l, j1 = 0; i1 <= r ; i1++, j1++) {
            nums[i1] = tmp[j1];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        long sum = merge_sort(arr,tmp,0, n - 1);
        System.out.println(sum);
    }
}
