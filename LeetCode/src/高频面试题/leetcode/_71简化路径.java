package 高频面试题.leetcode;

import java.util.Stack;
//设置一个栈
//栈为空的时候表示根目录
//每次parse的时候，检查两个/中间的东西
//  如果是..就pop
//  如果为空或者.啥也不做
//  是合法的目录名(不是..也不是.也不包含\/:*?"<>|")
//  就push到栈里面
public class _71简化路径 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] items = path.split("/");
        for (String item : items) {
            if (item.isEmpty() || item.equals(".")) {
                continue;
            }
            // 回退
            if (item.equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                //  文件夹名
                stack.push(item);
            }
        }
        return "/" + String.join("/", stack);
    }
}
