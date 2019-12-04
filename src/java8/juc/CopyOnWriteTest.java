package java8.juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @Deacription ConcurrentModificationException
 * @Author BarryLee
 * @Date 2019/12/2 10:48
 */
public class CopyOnWriteTest {
  public static void main(String[] args) {
    // 即便这里加了锁 - 每个方法都上锁，也是会产生并发修改的异常的
    List<String> list = Collections.synchronizedList(new ArrayList<>());
    list.add("sheshou");
    CopyOnWriteThread thread = new CopyOnWriteThread(list);

    //for(int i = 0; i<10;i++) {
    //  new Thread(thread).start();
    //}

    new Thread(thread).start();
  }
}
class CopyOnWriteThread implements Runnable {
  private List<String> list;
  public CopyOnWriteThread(List<String> list) {
    this.list = list;
  }
  @Override
  public void run() {
    // 遍历这个list，然后进行修改数据
    Iterator<String> iterator = list.iterator();
    while(iterator.hasNext()) {
      String s = iterator.next();
      System.out.println(s);

      // 修改数据 -- add
      list.add("11");
    }
  }
}