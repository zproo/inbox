package bobo.algo.graph_basics_07.finding_a_path_06.temp;

public interface Graph {
    // 返回节点个数
    public int V();

    // 返回边条数
    public int E();

    // 向图中添加一条边，从v到w
    public void addEdge(int v, int w);

    boolean hasEdge(int v, int w);

    // 返回顶点的所有临边
    public Iterable<Integer> adj(int v);

    void show();

}
