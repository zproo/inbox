package bobo.algo.graph_basics_07.bfs_and_shortest_path_07;

public class Main {

    // 测试无权图最短路径算法
    public static void main(String[] args) {

        String filename = "E:\\github\\inbox\\面试准备\\src\\bobo\\algo\\graph_basics_07\\bfs_and_shortest_path_07\\testG.txt";
        SparseGraph g = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();
        System.out.println();

        // 比较使用深度优先遍历和广度优先遍历获得路径的不同
        // 广度优先遍历获得的是无权图的最短路径
        Path dfs = new Path(g,0);
        System.out.print("DFS : ");
        dfs.showPath(6);

        ShortestPath bfs = new ShortestPath(g,0);
        System.out.print("BFS : ");
        bfs.showPath(6);
    }
}