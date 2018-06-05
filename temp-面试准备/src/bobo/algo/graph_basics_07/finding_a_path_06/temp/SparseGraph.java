package bobo.algo.graph_basics_07.finding_a_path_06.temp;

import java.util.Vector;

// 稀疏图 - 邻接表
public class SparseGraph implements Graph {

    private int n; // 图中的顶点个数
    private int m; // 图中的边条数
    private boolean directed; // 是否有向
    private Vector<Integer>[] g;

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.directed = directed;

        g = new Vector[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Vector<Integer>();
        }
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

        g[v].add(w);
        if (v != w && !directed) {
            g[w].add(v);
        }
    }

    public boolean hasEdge(int v, int w) {

        // 处理越界
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].elementAt(i) == w) {
                return true;
            }
        }

        return false;
    }

    // 返回顶点的所有临边
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;

        return g[v];
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print("vertex " + i + ":\t");
            for (int j = 0; j < g[i].size(); j++) {
                System.out.print(g[i].elementAt(j) + "\t");
            }
            System.out.println();
        }
    }
}
