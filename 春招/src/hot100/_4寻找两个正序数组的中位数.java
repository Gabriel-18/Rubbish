package hot100;

public class _4寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int idx1 = 0;
        int idx2 = 0;

        if (length % 2 == 0) {
            return (nums1[idx1] + nums2[idx2]) * 0.5;
        } else if (length % 2 == 1) {
            return nums1[idx1] < nums2[idx2] ? nums1[idx1] : nums2[idx2];
        }
        return -1;

    }

    // 归并
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int idx1 = 0, idx2 = 0, count = 0;
        int len = len1 + len2;
        int[] newarr = new int[len];

        while (idx1 != len1 && idx2 != len2) {
            if (nums1[idx1] <= nums2[idx2]) {
                newarr[count++] = nums1[idx1++];
            } else {
                newarr[count++] = nums2[idx2++];
            }
        }

        while (idx1 != len1) {
            newarr[count++] = nums1[idx1++];
        }

        while (idx2 != len2) {
            newarr[count++] = nums2[idx2++];
        }

        if (len % 2 == 0) {
            return (newarr[len / 2] + newarr[(len - 1) / 2]) * 0.5;
        } else {
            return newarr[len / 2] ;
        }


    }
}
