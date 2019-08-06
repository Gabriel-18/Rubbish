package leetcode;

import java.util.Arrays;

public class AssignCookies {
    /**
     * 贪心算法
     * 保证每次操作都是局部最优的，并且最后得到的结果是全局最优的
     *455. Assign Cookies
     * https://leetcode.com/problems/assign-cookies/description/
     * @param g children
     * @param s cookies
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        // 两者都从小到大排序
        Arrays.sort(g);
        Arrays.sort(s);

        int gi = 0, si = 0;
        // 同时正向遍历
        while (gi < g.length && si < s.length) {
            // 满足贪心规则
            // 当前能满足的
            if (g[gi] <= s[si]) {
                // 被满足的+1
                gi++;
            }
            //无论满足还是没满足都要+1
            si++;
        }
        return gi;
    }
}
