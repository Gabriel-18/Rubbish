package leetcode;

import java.util.Arrays;

public class AssignCookies {
    /**
     *455. Assign Cookies
     * https://leetcode.com/problems/assign-cookies/description/
     * @param g children
     * @param s cookies
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            // 满足贪心规则
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }
}
