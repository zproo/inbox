package priv.zj.sqlTest;

import java.util.concurrent.CountDownLatch;

public class SqlClient {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < 50; i++) {
            new Thread(new HandleSql(countDownLatch)).start();
        }
        countDownLatch.countDown();
    }
}
