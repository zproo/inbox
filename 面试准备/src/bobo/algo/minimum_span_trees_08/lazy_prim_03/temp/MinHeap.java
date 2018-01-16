package bobo.algo.minimum_span_trees_08.lazy_prim_03.temp;

// 最小堆
public class MinHeap<Item extends Comparable> {

    protected Item[] data; // 堆是一个完全二叉树，使用数组表示
    protected int count; // 堆中节点的个数
    protected int capacity; // 用来表示堆的数组大小

    public MinHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    // 使用数组构造一个堆
    public MinHeap(Item[] array) {

    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    // 向堆中插入一个元素
    public void insert(Item item) {
        assert count + 1 < capacity;

        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    public Item extractMin() {
        assert count > 0;

        Item ret = data[1];

        // 根节点和最后一个子节点交换位置
        swap(1, count);
        count--;
        shiftDown(1);

        return ret;
    }

    public Item getMin() {
        assert count > 0;
        return data[1];
    }

    // 交换堆中的两个元素
    private void swap(int i, int j) {
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    /*===========================最小堆核心辅助函数===========================*/
    // 插入一个新元素时，元素的上移操作
    private void shiftUp(int k) {
        // 存在数组中的完全二叉树中父节点坐标 = 子节点坐标 / 2
        while (k > 1 && (data[k / 2].compareTo(data[k]) > 0)) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    // 取出根元素时，最后一个元素替换根元素，之后下移到正确位置的操作
    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && (data[j + 1].compareTo(data[j]) < 0)) {
                j = j + 1;
            }

            if (data[k].compareTo(data[j]) < 0) {
                return;
            }
            swap(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        MinHeap<Integer> minHeap = new MinHeap<Integer>(100);
        int N = 100; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for( int i = 0 ; i < N ; i ++ )
            minHeap.insert( new Integer((int)(Math.random() * M)) );

        Integer[] arr = new Integer[N];
        // 将minheap中的数据逐渐使用extractMin取出来
        // 取出来的顺序应该是按照从小到大的顺序取出来的
        for( int i = 0 ; i < N ; i ++ ){
            arr[i] = minHeap.extractMin();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从小到大排列的
        for( int i = 1 ; i < N ; i ++ )
            assert arr[i-1] <= arr[i];
    }
}
