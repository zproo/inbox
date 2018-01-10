package bobo.algo.graph_basics_07.bfs_and_shortest_path_07.temp;

import java.util.Stack;
import java.util.Vector;

public class Path {

    private Graph G;
    private int s; // 起始点
    private boolean[] visited; // dfs过程中节点是否被访问
    private int[] from; // 记录路径

    // 深度优先遍历 - 以v为起点
    void dfs(int v) {
        visited[v] = true;

        // 遍历与节点v相邻的节点
        for (int i : G.adj(v)) {
            if (!visited[i]) {
                from[i] = v;
                dfs(i);
            }
        }
    }

    // 构造函数，寻路算法
    public Path(Graph graph, int s) {
        // 初始化
        G = graph;

        assert s >= 0 && s < G.V();

        visited = new boolean[G.V()];
        from = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            from[i] = -1; // from初始化为-1
        }
        this.s = s; // 指定起始点

        dfs(s);
    }

    // 从起始点s到点w是否连通
    boolean hasPath(int w) {
        assert w >= 0 && w < G.V();

        return visited[w];
    }

    // 从起始点s到点w的路径
    Vector<Integer> path(int w) {
        assert hasPath(w);

        Stack<Integer> s = new Stack<Integer>();

        int p = w;
        while (p != -1) {
            s.push(p);
            p = from[p];
        }

        Vector<Integer> res = new Vector<Integer>();
        while (!s.isEmpty()) {
            res.add(s.pop());
        }

        return res;
    }

    void showPath(int w) {
        assert hasPath(w);

        Vector<Integer> vector = path(w);
        for (int i = 0; i < vector.size(); i++) {
            System.out.print(vector.elementAt(i));
            if (i == vector.size() - 1) {
                System.out.println();
            } else {
                System.out.print(" -> ");
            }
        }

    }
}
