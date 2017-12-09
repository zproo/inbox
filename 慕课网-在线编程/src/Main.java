import priv.zj.mysql事务.HandleSql;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < 50; i++) {
            new Thread(new HandleSql(countDownLatch)).start();
        }
        countDownLatch.countDown();
    }
}
