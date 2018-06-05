package bobo.algo.minimum_span_trees_08.weighted_graph_01.temp;

// 图中边的存储结构
public class Edge<Weight extends Number & Comparable> implements Comparable<Edge> {
    private int a, b; // 边的两个顶点
    private Weight weight; // 权值，类型为泛型Weight，可自定义为任何类型

    public Edge(int a, int b, Weight weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    public Edge(Edge<Weight> edge) {
        this.a = edge.a;
        this.b = edge.b;
        this.weight = edge.weight;
    }

    public int v() {
        return a;
    }

    public int w() {
        return b;
    }

    // 返回边的权值
    public Weight wt() {
        return weight;
    }

    // 给定一个顶点，返回相连的另一个
    public int other(int x) {
        assert x == a || x == b;
        return x == a ? b : a;
    }

    // 输出边的信息
    @Override
    public String toString() {
        return "" + a + "-" + b + ": " + weight;
    }

    // 边之间的比较
    @Override
    public int compareTo(Edge that) {
        if (weight.compareTo(that.weight) < 0) {
            return -1;
        } else if (weight.compareTo(that.weight) > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
