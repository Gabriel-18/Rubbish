package Collection;

/**
 * 联系：
 *
 * 看两者源代码可以发现 copyOf()
 * 内部实际调用了 System.arraycopy() 方法
 *
 * 区别：
 *
 * arraycopy() 需要目标数组，将原数组拷贝到你自己定义的数组里或者原数组，
 * 而且可以选择拷贝的起点和长度以及放入新数组中的位置
 * copyOf() 是系统自动在内部新建一个数组，并返回该数组。
 */
public class ArraycopyTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 0 1 2 3 0 0 0 0 0 0
        int[] a = new int[10];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.arraycopy(a, 1, a, 3, 2);
        //a[2]=99;
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}