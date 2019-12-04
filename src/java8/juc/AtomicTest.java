package java8.juc;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/12/1 23:03
 */

/**
 * 线程可见性问题
 * volatile关键字可以保证线程的可见性
 */
public class AtomicTest {

  public static void main(String[] args) {
    MyThread mt = new MyThread();
    new Thread(mt).start();
    while(true) {
      if(mt.getValue()) {
        System.out.println("进来了");
        break;
      }
    }
  }

}
class MyThread implements Runnable {
  private volatile boolean value = false;
  @Override
  public void run() {
    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
    }
    System.out.println("run .. ");
    this.value = true;
  }
  public boolean getValue() {
    return value;
  }
}
