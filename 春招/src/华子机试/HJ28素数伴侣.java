package 华子机试;

import java.util.ArrayList;
import java.util.Scanner;

public class HJ28素数伴侣 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            ArrayList<Integer> even = new ArrayList<>();
            ArrayList<Integer> odd = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (arr[i] % 2 == 0) {
                    even.add(arr[i]);
                } else {
                    odd.add(arr[i]);
                }
            }

            // 记录匹配偶数的奇数值
            int[] evenMatch = new int[even.size()];
            int res = 0;
            // 遍历奇数去匹配偶数
            for (int i = 0; i < odd.size(); i++) {
                // 每一步重新创建 也就相当于清空
                // 标记对应的偶数是否查找过
               int[] used = new int[even.size()];
               // 采用匈牙利算法 先到先得
               if (find(odd.get(i), even, used, evenMatch)) {
                   res++;
               }
            }
            System.out.println(res);
        }
    }

    // 判断奇数x是否能找到伴侣
    private static boolean find(int x, ArrayList<Integer> even, int[] used, int[] evenMatch) {
       // 遍历偶数
        // 检查当前传入的奇数x是否与偶数集合中的哪些数字匹配
        for (int i = 0; i < even.size(); i++) {
            // 当前偶数位还没有匹配过奇数
            // 并且能与x组成素数伴侣
            if (isPrime(x + even.get(i)) && used[i] == 0) {
                used[i] = 1;
                // 如果i位置偶数 没有伴侣 则与x组成伴侣

                // 如果i位置偶数 已经有伴侣 并且该伴侣能够重新找到伴侣（递归调用）
                // 则奇数x可以设置为第i个偶数的伴侣
                // 这里采用匈牙利算法 能让就让
                if (evenMatch[i] == 0 || find(evenMatch[i], even, used, evenMatch)) {
                    evenMatch[i] = x;
                    return true;
                }
            }
        }
        return false;
    }

    // 判断素数
    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i * i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
