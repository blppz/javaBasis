package grammar2;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/23 21:54
 */
public class G35Volatile {

  /**
   * volatile的作用就是当有线程修改参数的时候，会及时同步到主存，
   * 同时其他线程会及时收到通知，收到通知之后到主存去读取，而不是缓存
   */

  //private static int a = 0;
  private volatile static int a = 0;
  public static void main(String[] args) throws InterruptedException {
    new Thread(() -> {
      // while死循环，里面什么都不写，让CPU疯狂循环这里的代码
      while(a == 0) {}
    }).start();

    Thread.sleep(1000);
    a = 1;
  }

  static class Singleton {
    private Singleton() {}

    // 注意这里的volatile
    private static volatile Singleton singleton;

    /**
     * 懒汉式
     */
    public static Singleton getInstance() {
      // double checked locking (DCL)
      if(null != singleton) {
        return singleton;
      }
      synchronized (Singleton.class) {
        if(null == singleton) {

          /**
           * 三个步骤
           * 1.开辟空间
           * 2.初始化信息
           * 3.将应用赋值给singleton
           *
           * 这里可能会出现比如初始化信息和赋值发生指令重排
           * 导致A线程在重排之后，B线程进来拿到的是一个null
           *
           * 也就是赋值了 但是！！只是在A线程的工作空间赋值了，还没更新到主存中
           */
          singleton = new Singleton();
        }
      }
      return singleton;
    }
  }
}
