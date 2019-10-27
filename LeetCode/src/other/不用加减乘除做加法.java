package other;

public class 不用加减乘除做加法 {
    public int Add(int num1,int num2) {
        return num2 == 0 ? num1 
                : Add(num1 ^ num2,(num1 & num2) << 1);
    }
}
