import java.util.ArrayList;
import java.util.List;

public class dfs {
    private List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        dfs(new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    public void dfs(List<Integer> curr, int[] arr, boolean[] used) {
        if (curr.size() == arr.length) {
            //注意不能直接添加temp
            res.add(new ArrayList<>(curr)); //以一个集合或数组初始化ArrayList al = new ArrayList(a);//a为集合或数组
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {//记录某个下标的数是否被使用过
                curr.add(arr[i]);
                used[i] = true;
                dfs(curr, arr, used);
                curr.remove(curr.size() - 1); //移除最后一个
                used[i] = false;
            }
        }
    }
}
