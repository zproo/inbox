package bobo.algo.heap_04.max_heap_class_basic_02.temp;

public class MaxHeap<Item> {
    private Item[] data;
    private int count;

    public MaxHeap(int capacity) {
        data = (Item[]) new Object[capacity + 1];
        count = 0; // 刚创建出来其中没有元素
    }

    public int size() {
        return count;
    }

    public boolean isempty() {
        return count == 0;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        System.out.println(maxHeap.size());
    }
}
