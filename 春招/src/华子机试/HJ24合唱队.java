package 华子机试;

import java.util.Arrays;
import java.util.Scanner;

public class HJ24合唱队 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            //dp[i] 的值代表 arr[i] 结尾的最长子序列长度。
            int[] left = new int[n];
            int[] right = new int[n];
            Arrays.fill(left,1);
            Arrays.fill(right,1);


            // 这段代码搞不清楚
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    // i 可以接在 j后
                    if (arr[i] > arr[j]) {
                        left[i] =Math.max(left[j] + 1, left[i]);
                    }
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                for (int j = n - 1; j > i; j--) {
                    if (arr[i] > arr[j]) {
                        right[i] =Math.max(right[j] + 1, right[i]);
                    }
                }
            }
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = left[i] + right[i] - 1;
            }
            int max = 1;
            for (int i = 0; i < n; i++) {
                max = Math.max(res[i], max);
            }
            System.out.println(n - max);
        }
    }
}
