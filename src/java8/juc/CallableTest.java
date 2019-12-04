package java8.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Deacription 使用线程的第三种方式
 * @Author BarryLee
 * @Date 2019/12/2 20:00
 */
public class CallableTest {
  public static void main(String[] args) {
    MyCall call = new MyCall();
    FutureTask<Integer> task = new FutureTask<>(call);
    new Thread(task).start();
    try {
      // 这个get会等到run执行完才会得到结果
      Integer s = task.get();
      System.out.println(s);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
  }
}
class MyCall implements Callable {
  @Override
  public Object call() throws Exception {
    int sum = 0;
    for(int i = 0; i<Integer.MAX_VALUE;i++) {
      sum += i;
    }
    return sum;
  }
}