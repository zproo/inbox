package bobo.algo.minimum_span_trees_08.weighted_graph_01.temp;

public interface WeightedGraph<Weight extends Number & Comparable> {
    public int V();
    public int E();
    public void addEdge(Edge<Weight> edge);
    boolean hasEdge(int v, int w);
    void show();
    public Iterable<Integer> adj(int v);
}
