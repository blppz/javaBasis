package grammar2;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/24 20:49
 */
public class G42Talk_B {
  public static void main(String[] args) {
    new Thread(new G42UDPTalkReceive(9999)).start();

    new Thread(new G42UDPTalkSend("localhost",8888)).start();
  }
}
