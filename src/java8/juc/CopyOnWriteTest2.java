package java8.juc;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/12/2 11:59
 */
public class CopyOnWriteTest2 {
  public static void main(String[] args) {
    CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
    list.add("aaa");

    CopyOnWriteTestThread2 thread2 = new CopyOnWriteTestThread2(list);
    for(int i = 0; i<10; i++) {
      new Thread(thread2).start();
    }
  }
}
class CopyOnWriteTestThread2 implements Runnable{
  private CopyOnWriteArrayList<String> list;
  public CopyOnWriteTestThread2(CopyOnWriteArrayList<String> list ) {
    this.list = list;
  }

  @Override
  public void run() {
    Iterator<String> iterator = list.iterator();
    while(iterator.hasNext()) {
      System.out.println(Thread.currentThread().getName() + ": " + iterator.next());

      // 添加
      list.add("添加");
    }
  }
}