package grammar2;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/22 20:56
 */
public class G28UnsaveThreadDemo {
  /**
   * 两个线程同时进行写操作的并发问题
   */
  public static void main(String[] args) {
    Account account = new Account(100, "两公婆的财产");
    Thread you = new Thread(new Drawing(account, 60, "我"));
    Thread wife = new Thread(new Drawing(account, 60,"我老婆"));

    you.start();
    wife.start();
  }
  static class Account{
    int money;
    String name;
    public Account(int money, String name) {
      this.money = money;
      this.name = name;
    }
    public void drawMoney(int money) {
      //如果加锁，在这加一个synchronized(account) {...}
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
    public int getMoney() {
      return money;
    }
  }
  static class Drawing implements Runnable{
    // 账户
    Account account;
    // 取出多少钱
    int getMoney;
    // 谁取了钱
    String name;

    public Drawing (Account account, int getMoney, String name) {
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
