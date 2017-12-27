package bobo.algo.heap_04.heapify_05.temp;


public class MaxHeap<Item extends Comparable> {
    protected Item[] data;
    protected int count;
    protected int capacity; // 堆容量存储


    public MaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        count = 0; // 刚创建出来其中没有元素
        this.capacity = capacity;
    }

    // 构造函数重载，使用一个数组构建一个堆


    public MaxHeap(Item[] arr) {
        int n = arr.length;

        data = (Item[]) new Comparable[n + 1];
        // 把数组元素放入一个堆中
        for (int i = 0; i < n; i++) {
            data[i + 1] = arr[i]; // 堆从·开始
        }

        count = n;

        // 调整堆为一个最大堆（从第一个非叶子节点开始）
        for (int i = count / 2; i > 0; i--) {
            shiftDown(i);
        }

    }

    public int size() {
        return count;
    }

    public boolean isempty() {
        return count == 0;
    }


    /*
     * 向堆中插入一个节点
     * */
    public void insert(Item item) {
        assert count + 1 <= this.capacity;

        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    /*
     * 从堆中取出一个元素（只能是根元素，最大堆取出的即最大值）
     * */
    public Item extractMax() {
        assert count > 0;
        Item ret = data[1];

        swap(1, count);
        count--;

        shiftDown(1);

        return ret;
    }


    // 交换堆中的i和j两个元素
    private void swap(int i, int j) {
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    /*=============================最大堆核心辅助函数=============================*/
    /*
     * 将新添加到堆中的节点移动到正确的位置
     * */
    private void shiftUp(int k) {
        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0) {
                j++;
            }

            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }


    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);

        int N = 100;
        int M = 100;
        for (int i = 0; i < N; i++) {
            maxHeap.insert(new Integer((int) (Math.random()*M)));
        }

        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = maxHeap.extractMax();
            System.out.print(arr[i] + " ");
        }


    }
}
























