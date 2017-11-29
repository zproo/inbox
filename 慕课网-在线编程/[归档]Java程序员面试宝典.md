# Java程序员面试宝典

### 1. （p74）典型的递归问题：把一个数组里的组合全部列出，例如1 2，列出为1，2，12，21

```java
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] str = new String[] { "1", "2", "3", "4" };
        listAll(Arrays.asList(str), "");
    }

    public static void listAll(List candidate, String prefix) {
        if (!prefix.equalsIgnoreCase(""))  //这儿体现了递归的出口
            System.out.println(prefix);
        for (int i = 0; i < candidate.size(); i++) {
            List temp = new LinkedList(candidate);	//增删元素效率高
            listAll(temp, prefix + temp.remove(i));// remove()返回被删除的元素
        }
    }
}
```

### 2.（p76）一个字符串可能包含a-z多个字符，如String input = "qqqwwweeerrttyyuuiop";，求出出现次数最多的字符及次数，如有多个同次数的字符则都输出。

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String input = "qqqwwweeerrttyyuuiop";
//        main方法中不能直接用非static的变量、函数
        new Main().doString(input);
    }

    public void doString(String input) {
        char[] chars = input.toCharArray();

        // ================字符串排序================
        ArrayList lists = new ArrayList();

        TreeSet set = new TreeSet();
        for (int i = 0; i < chars.length; i++) {
            lists.add(String.valueOf(chars[i]));
            set.add(String.valueOf(chars[i]));
        }

        Collections.sort(lists);

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < lists.size(); i++) {
            stringBuffer.append(lists.get(i));
        }
        input = stringBuffer.toString();    // 排好序的输入字符串

        // ================字符串处理================
        int max = 0;
        String maxString = "";
        ArrayList maxList = new ArrayList();

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            String os = (String) iterator.next();
            int begain = input.indexOf(os);
            int last = input.lastIndexOf(os);
            int value = last - begain + 1;

            if (value > max) {
                max = value;
                maxString = os;
                maxList.add(os);
            } else if (value == max) {
                maxList.add(os);
            }
        }

        // ================输出处理结果================
        System.out.print("maxData:");
        for (int i = 0; i < maxList.size(); i++) {
            System.out.print(maxList.get(i) + " ");
        }
        System.out.println("max:" + max);

    }
}
```



```java
import java.util.*;

import java.util.TreeSet;

public class Main {
    static int count = 0;//排列种类

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        String s = "1223";

        Pailie(s, "");
    }

    static void Pailie(String s, String p) {
//        System.out.println("s: " + s);
//        System.out.println("p: " + p);

        if (s.length() < 1) {
            count++;
//            System.out.println("count: " + count);

            if ("" != p) System.out.println(p);
        } else {
            int index[] = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {  //该字符首次索引
                //Returns the index within this string of the first occurrence of the specified character
                index[i] = s.indexOf(s.charAt(i));
            }
            for (int i = 0; i < s.length(); i++) {
                if (i == index[i]) {    //关键：保证相同字符中的第一次调用
                    Pailie(s.substring(1), p + s.substring(0, 1));
                }
                s = s.substring(1) + s.substring(0, 1);//循环移位，使每次都是在起始位置选择第一个Pailie(s.substring(1),p+s.substring(0,1));----bug:原来的s未释放
            }
        }
    }

}
```

