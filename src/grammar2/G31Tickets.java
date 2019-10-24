package grammar2;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/23 9:43
 */
public class G31Tickets {
  /**
   * 多线程模拟订票
   */
  public static void main(String[] args) {
    Web12306 web12306 = new Web12306(3, "八爪鱼站");
    Client c1 = new Client(2, web12306, "老噶那么");
    Client c2 = new Client(2, web12306, "小饼干");
    c2.start();
    c1.start();
  }

  /**
   * Client类是一个代理类的子类
   */
  static class Client extends Thread{
    int seats;
    public Client(int seats, Runnable web12306, String threadName) {
      super(web12306, threadName);
      this.seats = seats;
    }
  }
  static class Web12306 implements Runnable{
    int ticketNum;
    String name;
    public Web12306(int ticketNum, String name) {
      this.ticketNum = ticketNum;
      this.name = name;
    }

    @Override
    public void run() {
      System.out.println("欢迎光临"+ name +"站购票..");
      Client c = (Client) Thread.currentThread();
      if(bookTicket(c.seats)) {
        System.out.println("恭喜" + c.getName() + "出票成功 ->" + c.seats);
        System.out.println("余票：" + ticketNum);
      } else {
        System.out.println("没票了,余票：" + ticketNum);
      }
    }
    private boolean bookTicket(int needNum) {
      if(needNum > ticketNum) {
        return false;
      }
      synchronized (this) {
        if(needNum > ticketNum) {
          return false;
        }
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        ticketNum -= needNum;
        return true;

      }
    }
  }
}
