package priv.zj.others;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.Vector;

public class Main {

    public static void run() {
        int n = 10;
        Vector[] g;
        g = new Vector[10];

        for (int i = 0; i < n; i++) {
            g[i] = new Vector<Boolean>();
            for (int j = 0; j < 5; j++) {
                g[i].add(j+"aaa");
            }
        }

        // show
        for( int i = 0 ; i < n ; i ++ ){
            System.out.print("vertex " + i + ":\t");
            for( int j = 0 ; j < g[i].size() ; j ++ )
                System.out.print(g[i].elementAt(j) + "\t");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Main.run();

    }
}
