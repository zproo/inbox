package bobo.algo.graph_basics_07.finding_a_path_06.temp;

import java.util.Vector;

// 稠密图 - 邻接矩阵
public class DenseGraph implements Graph {

    private int n; // 图中的顶点个数
    private int m; // 图中的边条数
    private boolean directed; // 是否有向
    private boolean[][] g; // 二维数组存储图的具体数据、

    public DenseGraph(int n, boolean directed) {
        assert n >= 0;

        this.n = n;
        this.m = 0;
        this.directed = directed;

        // bollean数组默认为false
        g = new boolean[n][n];
    }

    // 返回节点个数
    public int V() {
        return n;
    }

    // 返回边条数
    public int E() {
        return m;
    }

    // 向图中添加一条边，从v到w
    public void addEdge(int v, int w) {

        // 处理越界
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        if (hasEdge(v, w)) {
            return;
        }

        g[v][w] = true;
        if (!directed) { // 无向图
            g[w][v] = true;
        }
    }

    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        return g[v][w];
    }

    // 返回顶点的所有临边
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;

        Vector<Integer> adjV = new Vector<Integer>();
        for (int i = 0; i < n; i++) {
            if (g[v][i]) {
                adjV.add(i);
            }
        }

        return adjV;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((g[i][j] ? 1 : 0) + "\t");
            }
            System.out.println();
        }
    }
}
