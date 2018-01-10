package bobo.algo.graph_basics_07.bfs_and_shortest_path_07.temp;

public class Components {

    Graph G; // 图的引用
    private boolean[] visited; //节点是否被访问
    private int ccount; // 第几个联通分量
    private int[] id; // 用于存储每个节点属于的连通分量

    // 构造函数，求出无权图的连通分量
    public Components(Graph graph) {

        // 算法初始化
        G = graph;
        visited = new boolean[G.V()];
        id = new int[G.V()];
        ccount = 0;
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            id[i] = -1; // 初始化为-1
        }

        // 计算连通分量
        for (int i = 0; i < G.V(); i++) {
            if (!visited[i]) {
                dfs(i);
                ccount++;
            }
        }
    }

    // 深度优先遍历 - 以v为起点
    void dfs(int v) {
        visited[v] = true;
        id[v] = ccount;

        // 遍历与节点v相邻的节点
        for (int i : G.adj(v)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    public int count() {
        return ccount;
    }

    public boolean isConnected(int v, int w) {
        assert v >= 0 && v < G.V();
        assert w >= 0 && w < G.V();

        return id[v] == id[w];
    }
}
