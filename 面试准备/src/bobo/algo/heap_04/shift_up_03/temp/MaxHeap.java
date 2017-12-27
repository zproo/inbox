package bobo.algo.heap_04.shift_up_03.temp;



public class MaxHeap<Item extends Comparable> {
    protected Item[] data;
    protected int count;
    protected int capacity; // 堆容量存储


    public MaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        count = 0; // 刚创建出来其中没有元素
        this.capacity = capacity;
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
        assert count + 1 <= capacity;

        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    /*
     * 将新添加到堆中的节点移动到正确的位置
     * */
    private void shiftUp(int k) {
        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    /*
     * 交换堆中的i和j两个元素
     * */
    private void swap(int i, int j) {
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        int N = 50;
        int M = 100;
        for (int i = 0; i < N; i++) {
            maxHeap.insert(new Integer((int) (Math.random() * M)));
        }
        System.out.println(maxHeap.size());
    }
}
























