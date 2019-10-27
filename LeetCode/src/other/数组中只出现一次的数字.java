package other;

public class 数组中只出现一次的数字 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        // 两个不相等的元素在位级表示上必定会有一位存在不同，
        // 将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。
        int diff = 0;
        for (int num : array) {
            diff ^= num;
        }
        // ???
//        diff &= -diff 得到出 diff 最右侧不为 0 的位，
//        也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，利用这一位就可以将两个元素区分开来。
        diff &= -diff;
        for (int num : array) {
            if ((num & diff) == 0) {
                num1[0] ^= num;
            } else {
                num2[0] ^= num;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(4&-4);
    }

}
