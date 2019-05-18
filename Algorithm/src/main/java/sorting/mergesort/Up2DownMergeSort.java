package sorting.mergesort;

public class Up2DownMergeSort<T extends Comparable<T>> extends MergeSort<T> {
    @Override
    public void sort(T[] nums) {
        aux = (T[]) new Comparable[nums.length];
        sort(nums,0,nums.length - 1);

    }
    private void sort(T[] nums, int l, int h) {
        // Sort a[lo..hi].
        if (h <= l) {
            return;
        }

        int mid = l + (h - l) / 2;
        sort(nums, l, mid); // Sort left half
        sort(nums, mid + 1, h); // Sort right half
        merge(nums, l, mid, h); // Merge results (code on page 271)
    }
    //@Override
    //public void sort(T[] nums) {
    //    aux = (T[]) new Comparable[nums.length];
    //    sort(nums, 0, nums.length - 1);
    //}
    //
    //private void sort(T[] nums, int l, int h) {
    //    if (h <= l) {
    //        return;
    //    }
    //    int mid = l + (h - l) / 2;
    //    sort(nums, l, mid);
    //    sort(nums, mid + 1, h);
    //    merge(nums, l, mid, h);
    //}


    public static void main(String[] args) {
        Up2DownMergeSort<Integer> s = new Up2DownMergeSort<>();
        //Integer[] a ={1,2,3,4,1,2,3,4};
        Integer[] a ={1,2,1,2};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        s.sort(a);
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            //System.out.println(a[i]);
            System.out.print(a[i]+" ");

        }
    }
}
