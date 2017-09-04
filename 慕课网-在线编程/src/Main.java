import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

//计算字符个数
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int number = sc.nextInt();
            Integer[] ints = new Integer[number];

            for (int i = 0; i < number; i++) {
                ints[i] = sc.nextInt();
            }

            // 得到int类型数组，去重、排序（TreeSet可以一次完成）
            TreeSet<Integer> tset = new TreeSet<Integer>(Arrays.asList(ints));
            Iterator i = tset.iterator();
            while (i.hasNext()) {
                System.out.println(i.next());
            }

        }


    }
}
