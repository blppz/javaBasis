package grammar2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Deacription Callable使用示例
 *
 * 初级阶段用的少，但是要知道一些，
 * 它的好处是可以由返回值和能够抛出异常
 *
 * @Author BarryLee
 * @Date 2019/10/21 21:59
 */
public class G19Callable <V> implements Callable<V> {
  public static void main(String[] args) {
    G19Callable<Object> callable = new G19Callable<>();
    FutureTask<Object> task = new FutureTask<>(callable);
    new Thread(task).start();
  }

  @Override
  public V call() throws Exception {
    System.out.println("call");
    return null;
  }
}
