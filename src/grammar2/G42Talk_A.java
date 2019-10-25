package grammar2;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/24 20:49
 */
public class G42Talk_A {

  /**
   * 存在一下四个线程
   * A talk     B receive
   * A receive  B send
   * 所以一边说bye关闭的时候，另一边也要说bye才可以关闭两个对象中总四个线程
   */

  public static void main(String[] args) {
    new Thread(new G42UDPTalkSend("localhost", 9999)).start();

    new Thread(new G42UDPTalkReceive(8888)).start();
  }
}
