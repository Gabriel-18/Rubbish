package 高频面试题.leetcode;

import java.util.Stack;
/** 只需删除重复项即可，因此可以使用栈实现
 * 每次添加时比较是否与栈顶元素相同
 *   - 若相同则删除栈顶元素且不插入
 *   - 若不相同则插入新元素
 * 时间复杂度：O(N)
 * 空间复杂度：O(N)
 */
public class _1047删除字符串中的所有相邻重复项 {
    public String removeDuplicates(String S) {

        char[] s = S.toCharArray();
        int len = s.length;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty() || s[i] != stack.peek()) {
                stack.push(s[i]);
            } else {
                stack.pop();
            }
        }
        /* 数据的展示可以继续优化 */
        StringBuilder str = new StringBuilder();
        for (Character c : stack) {
            str.append(c);
        }
        return str.toString();

    }
}
