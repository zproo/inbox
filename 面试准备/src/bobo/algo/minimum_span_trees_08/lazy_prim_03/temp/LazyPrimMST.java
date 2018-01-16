package bobo.algo.minimum_span_trees_08.lazy_prim_03.temp;

import java.util.Vector;

// 使用prim算法求图的最小生成树
public class LazyPrimMST<Weight extends Number & Comparable> {

    private WeightedGraph<Weight> G;
    private MinHeap<Edge<Weight>> pq;
    private boolean[] marked;
    private Vector<Edge<Weight>> mst;
    private Number mstWeight;


    // 构造函数，使用prim算法求图的最小生成树

    public LazyPrimMST(WeightedGraph<Weight> g) {
        // 初始化
        G = g;
        pq = new MinHeap<Edge<Weight>>(G.E()); // 优先队列大小等于图中边的条数
        marked = new boolean[G.V()];
        mst = new Vector<Edge<Weight>>();

        visit(0); // 从第0个节点开始找
        while (!pq.isEmpty()) {

            Edge<Weight> e = pq.extractMin();
            // 如果边的两个点都访问了，跳过此边，寻找下一条
            if (marked[e.v()] == marked[e.w()]) {
                continue;
            }

            mst.add(e);
            if (!marked[e.v()]) {
                visit(e.v());
            } else {
                visit(e.w());
            }
        }

        // 计算minWeight
        mstWeight = mst.elementAt(0).wt();
        for (int i = 1; i < mst.size(); i++) {
            mstWeight = mstWeight.doubleValue() + mst.elementAt(i).wt().doubleValue();
        }
    }

    // 访问节点v
    private void visit(int v) {
        assert !marked[v];

        marked[v] = true;
        // 相邻的边入优先队列
        for (Edge<Weight> e : G.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.insert(e);
            }
        }
    }

    Vector<Edge<Weight>> mstEdges() {
        return mst;
    }

    Number result() {
        return mstWeight;
    }
}
