package sorting.heap;

public class Heap<T extends Comparable<T>> {

    private T[] heap;
    private int N = 0;


    public Heap(int maxN) {
        this.heap = (T[]) new Comparable[maxN + 1];
    }


    public boolean isEmpty() {
        return N == 0;
    }


    public int size() {
        return N;
    }


    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }


    private void swap(int i, int j) {
        T t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    /***
     * 在堆中，当一个节点比父节点大，那么需要交换这个两个节点。
     * 交换后还可能比它新的父节点大，因此需要不断地进行比较和交换操作，把这种操作称为上浮
     *  Exchange key in child with key in parent
     *  Repeat until heap order restored
     * @param k parent node
     */
    private void swim(int k) {

        while (k > 1 && less(k / 2, k)) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 类似地，当一个节点比子节点来得小，也需要不断地向下进行比较和交换操作，把这种操作称为下沉。
     * 一个节点如果有两个子节点，应当与两个子节点中最大那个节点进行交换。
     * @param k
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            //j,j+1 代表子节点
            //Exchange key in parent with key in larger child
            // Repeat until heap order restored
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    /**
     * 将新元素放到数组末尾，然后上浮到合适的位置。
     * @param v
     */
    public void insert(T v) {
        heap[++N] = v;
        swim(N);
    }

    /**
     * 从数组顶端删除最大的元素，
     * 并将数组的最后一个元素放到顶端，并让这个元素下沉到合适的位置。
     * Exchange root with node at end, then sink it down.
     * @return
     */
    public T delMax() {
        T max = heap[1];
        swap(1, N--);
        //prevent loitering
        heap[N + 1] = null;
        sink(1);
        return max;
    }
}
