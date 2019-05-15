package bobo.algo.graph_basics_07.dfs_and_components_05.temp;

import bobo.algo.graph_basics_07.dfs_and_components_05.temp.Components;
import bobo.algo.graph_basics_07.dfs_and_components_05.temp.ReadGraph;
import bobo.algo.graph_basics_07.dfs_and_components_05.temp.SparseGraph;

// 测试图的联通分量算法
public class Main {

    public static void main(String[] args) {

        // TestG1.txt
        String filename1 = "E:\\github\\inbox\\面试准备\\src\\bobo\\algo\\graph_basics_07\\dfs_and_components_05\\testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename1);
        Components component1 = new Components(g1);
        System.out.println("TestG1.txt, Component Count: " + component1.count());
        System.out.println();

        // TestG2.txt
        String filename2 = "E:\\github\\inbox\\面试准备\\src\\bobo\\algo\\graph_basics_07\\dfs_and_components_05\\testG2.txt";
        SparseGraph g2 = new SparseGraph(6, false);
        ReadGraph readGraph2 = new ReadGraph(g2, filename2);
        Components component2 = new Components(g2);
        System.out.println("TestG2.txt, Component Count: " + component2.count());
    }
}