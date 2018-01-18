package bobo.algo.sorting_basic_02.insertion_sort_advance_06;

/*
* 位置：第二章4-6-选择、插入 8：50
* */
public class InsertionSort{

    // 我们的算法类不允许产生任何实例
    private InsertionSort(){}

    /*
    * 注意：插入排序的
    * */
    public static void sort(Comparable[] arr){

        int n = arr.length;
        for (int i = 1; i < n; i++) {

            // 寻找元素arr[i]合适的插入位置

            // ========================================================
            // 写法1
            for( int j = i ; j > 0 ; j -- )
                // 注意：插入排序虽然是稳定的，但是这里如果是 <=0，则变为不稳定。稳定的算法也与写法有关
                if( arr[j].compareTo( arr[j-1] ) < 0 )
                    swap( arr, j , j-1 );
                else
                    break;

            // ========================================================
            // 写法2 （每次比较成功都要进行交换）
//            for( int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0 ; j--)
//                swap(arr, j, j-1);

            // ========================================================
            // 写法3 (把最小值保存起来，只在最后一次才交换)
            // 在数组近乎有序时，排序速度可以超过O(nlogn)级别的排序算法，有很强实用意义
            // 完全有序数组时可达到O(n)级别
//            Comparable e = arr[i];
//            int j = i;
//            for( ; j > 0 && arr[j-1].compareTo(e) > 0 ; j--)
//                arr[j] = arr[j-1];
//            arr[j] = e;
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试InsertionSort
    public static void main(String[] args) {

        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("bobo.algo.sorting_basic_02.insertion_sort_advance_06.InsertionSort", arr);

        return;
    }
}