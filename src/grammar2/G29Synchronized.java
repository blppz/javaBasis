package grammar2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/22 21:52
 */
public class G29Synchronized {
  /**
   * synchronized在方法上，锁的是对象this
   * synchronized在块上（局部块）
   */
  /**
   * 两个线程同时进行写操作的并发问题
   */
  public static void main(String[] args) {
    G28UnsaveThreadDemo.Account account = new G28UnsaveThreadDemo.Account(100, "两公婆的财产");
    Thread you = new Thread(new G28UnsaveThreadDemo.Drawing(account, 60, "我"));
    Thread wife = new Thread(new G28UnsaveThreadDemo.Drawing(account, 60,"我老婆"));

    you.start();
    wife.start();

    // 另一个锁的例子
    List<String> list = new ArrayList<>();
    for(int i = 0; i < 100; i++) {
      new Thread(() -> {
        synchronized (list) {
          list.add(Thread.currentThread().getName());
        }
      }).start();
    }
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(list.size());
  }
  static class Account{
    int money;
    String name;
    public Account(int money, String name) {
      this.money = money;
      this.name = name;
    }
    public void drawMoney(int money) {
      // 这个判断可以提高效率，非常重要，因为如果小于的情况下，还是会进行等待，但加了这句就不会了
      // double checking
      if(money > this.money) return;

      synchronized (this) {
        if(money > this.money) {
          throw new RuntimeException("你个穷鬼，余额不足了！");
        }
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        this.money -= money;
      }
    }
    public int getMoney() {
      return money;
    }
  }
  static class Drawing implements Runnable{
    // 账户
    G28UnsaveThreadDemo.Account account;
    // 取出多少钱
    int getMoney;
    // 谁取了钱
    String name;

    public Drawing (G28UnsaveThreadDemo.Account account, int getMoney, String name) {
      this.account = account;
      this.getMoney = getMoney;
      this.name = name;
    }

    @Override
    public void run() {
      account.drawMoney(getMoney);
      System.out.println(name + ":" + account.name + "获取->" + getMoney + ", 余额->" + account.getMoney());
    }
  }
}
