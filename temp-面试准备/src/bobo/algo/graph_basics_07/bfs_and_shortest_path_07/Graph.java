package bobo.algo.graph_basics_07.bfs_and_shortest_path_07;

// 图的接口
public interface Graph {

    public int V();
    public int E();
    public void addEdge(int v, int w);
    boolean hasEdge(int v, int w);
    void show();
    public Iterable<Integer> adj(int v);
}