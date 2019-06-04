package functional;

// functional/IntCall.java

/**
 * 任何 Lambda 表达式的基本语法是：
 *
 * 参数。
 *
 * 接着 ->，可视为“产出”。
 *
 * -> 之后的内容都是方法体。
 *
 * [1] 当只用一个参数，可以不需要括号 ()。 然而，这是一个特例。
 *
 * [2] 正常情况使用括号 () 包裹参数。 为了保持一致性，也可以使用括号 () 包裹单个参数，虽然这种情况并不常见。
 *
 * [3] 如果没有参数，则必须使用括号 () 表示空参数列表。
 *
 * [4] 对于多个参数，将参数列表放在括号 () 中。
 */
interface IntCall {
    int call(int arg);
}
// functional/RecursiveFactorial.java

public class RecursiveFactorial {
    static IntCall fact;
    public static void main(String[] args) {
        fact = (n) -> n == 0 ? 1 : n * fact.call(n - 1);
        for(int i = 0; i <= 10; i++)
            System.out.println(fact.call(i));
    }
}
