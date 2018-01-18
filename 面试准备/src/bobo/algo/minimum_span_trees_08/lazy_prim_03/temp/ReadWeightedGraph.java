package bobo.algo.minimum_span_trees_08.lazy_prim_03.temp;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadWeightedGraph {

    private Scanner scanner; // 一个可以使用正则表达式来解析基本类型和字符串的简单文本扫描器。

    // 由于文件格式的限制，我们的文件读取类只能读取权值为Double类型的图
    public ReadWeightedGraph(WeightedGraph<Double> graph, String filename) {

        readFile(filename);

        try {
            // 读取节点数+边数
            int V = scanner.nextInt();
            if (V < 0) {
                throw new IllegalArgumentException("number of vertices in a1_数组 Graph must be nonnegative");
            }
            assert V == graph.V();

            int E = scanner.nextInt();
            if (E < 0) {
                throw new IllegalArgumentException("number of edges in a1_数组 Graph must be nonnegative");
            }

            for (int i = 0; i < E; i++) {
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                Double weight = scanner.nextDouble();

                assert v >= 0 && v < V;
                assert w >= 0 && w < V;

                graph.addEdge(new Edge<Double>(v, w, weight));
            }
        } catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'int' value from input stream, but the next token is \"" + token + "\"");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("attemps to read an 'int' value from input stream, but there are no more tokens available");
        }

    }

    private void readFile(String filename) {

        assert filename != null;

        try {
            File file = new File(filename);
            if (file.exists()) {

                FileInputStream fileInputStream = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fileInputStream), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            } else {
                throw new IllegalArgumentException(filename + " doesn't exist.");
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not open " + filename, e);
        }
    }
}
