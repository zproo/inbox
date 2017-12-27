package bobo.algo.heap_04.heapify_05.temp;

import java.lang.reflect.Method;

public class SortTestHelper {
    // 不允许产生实例
    private SortTestHelper() {
    }

    // 生成n个元素的随机数组，每个元素的随机范围为[rangeL,  rangeR]
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Integer((int) (Math.random() * (rangeR - rangeL)));
        }
        return arr;
    }

    // 打印数组arr所有内容
    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
        return;
    }

    // 判断arr是否有序
    public static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length -1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    // 计算算法的执行时间
    public static void testSort(String sortClassName, Comparable[] arr) {
        try {
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            // 通过Class获得排序方法(第二个参数时一个Class类型的数组)
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            // 排序时要比较的数组
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();

            assert isSorted(arr);

            System.out.println(sortClass.getSimpleName() + ":" + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}


























