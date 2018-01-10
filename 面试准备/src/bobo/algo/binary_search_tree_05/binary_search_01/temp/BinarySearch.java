package bobo.algo.binary_search_tree_05.binary_search_01.temp;

public class BinarySearch {

    // 该类不允许被实例化
    private BinarySearch() {}

    // 前提：array是有序数组
    // 如果没有找到target，返回-1
    public static int find(Comparable[] array, Comparable target) {
        int left = 0;
        int right = array.length - 1;

        // 在array[left...right]之中查找target
        while (left <= right) {
            // left和right都是int型最大值时，会发生整形溢出
//            int mid = (left + right) / 2;
            // 修改
            int mid = left + (right - left) / 2;

            if (array[mid].compareTo(target) == 0) {
                return mid;
            }

            if (array[mid].compareTo(target) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr = new Integer[N];
        for(int i = 0 ; i < N ; i ++)
            arr[i] = new Integer(i);

        // 对于我们的待查找数组[0...N)
        // 对[0...N)区间的数值使用二分查找，最终结果应该就是数字本身
        // 对[N...2*N)区间的数值使用二分查找，因为这些数字不在arr中，结果为-1
        for(int i = 0 ; i < 2*N ; i ++) {
            int v = BinarySearch.find(arr, new Integer(i));
            if (i < N)
                assert v == i;
            else
                assert v == -1;
        }

        return;
    }

}
