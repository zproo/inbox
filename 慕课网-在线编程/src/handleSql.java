import java.sql.*;
import java.util.concurrent.CountDownLatch;

/**
 * Created by zproo on 2017/11/27.
 */
public class handleSql implements Runnable {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/imooc?useUnicode=true&amp;characterEncoding=utf-8";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    CountDownLatch latch;


    public handleSql(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            this.latch.await();

            String result = execTransaction();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String execTransaction() {
        try {
            // 1.加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.通过数据库驱动获得数据库连接
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            conn.setAutoCommit(false);

            try {
                // 3.创建连接对象，通过数据库连接对象创建sql语句并执行
                Statement stmt = conn.createStatement();
                // =========================先查询，后更新=========================
                // 查询数据
                ResultSet rs = stmt.executeQuery("SELECT * FROM test WHERE id = 1 for UPDATE");
                int i = -1;
                while (rs.next()) {
                    i = rs.getInt("limit");
                }
                if (i > 0) {
                    // 修改数据
                    stmt.executeUpdate("UPDATE test SET test.`limit` = test.`limit`-1 WHERE id=1");
                    conn.commit();
                    return "success";
                } else {
                    conn.rollback();
                    return "fail1";
                }



                // =========================先更新，后查询=========================
                /*stmt.executeUpdate("UPDATE test SET test.`limit` = test.`limit`-1 WHERE id=1");

                ResultSet rs = stmt.executeQuery("SELECT * FROM test WHERE id = 1");
                int i = -1;
                while (rs.next()) {
                    i = rs.getInt("limit");
                }
                if (i < 1) {
                    // 修改数据
                    conn.rollback();
                    return "fail1";
                } else {
                    conn.commit();
                    return "success";
                }*/

            } catch (Exception e) {
                conn.rollback();
                e.printStackTrace();
                return "fail2";
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "fail0";
    }
}
