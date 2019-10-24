package grammar2;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/22 10:40
 */
public class G23ThreadStop {
  /**
   * 停止线程执行，有个stop方法，但是已经过时了，不建议使用
   * 可以使用flag标记来进行外部的控制
   */
  public static void main(String[] args) throws InterruptedException {
    MyRun r = new MyRun();
    new Thread(r).start();

    Thread.sleep(100);
    r.terminate();
  }
  static class MyRun implements Runnable {

    private boolean stop = false;

    @Override
    public void run() {
      int i = 0;
      while(!stop) {
        System.out.println(i++);
      }
    }

    public void terminate() {
      stop = true;
    }
  }
}
