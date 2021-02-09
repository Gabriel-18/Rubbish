package 剑指offer;

public class 求n项和 {
    public int Sum_Solution(int n) {
        int sum = n;
        //递归出口 n > 0
        //
//        boolean b = (n > 0) && (sum += Sum_Solution(n-1)) > 0;
        if (n > 0) {
            sum += Sum_Solution(n - 1);
        }
        return sum;
    }
}
