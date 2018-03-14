package priv.zj.myalgo.indexing;

public class SearchDemo {
    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        int result = funbinSearch(array, 3);
        System.out.println(result);
    }

    //给定有序查找表array 二分查找给定的值data
    //查找成功返回下标 查找失败返回-1
    static int funbinSearch(int[] array, int data) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (data == array[mid]) {
                return mid;
            } else if (data < array[mid]) {
                high = mid - 1;
            } else if (data > array[mid]) {
                low = mid + 1;
            }
        }

        return -1;
    }
}
