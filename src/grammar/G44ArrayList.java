package grammar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/17 21:55
 */
public class G44ArrayList {

  /**
   * 扩容机制方法为：
   * private void grow(int minCapacity)
   * int newCapacity = oldCapacity + (oldCapacity >> 1);
   * 默认为10 --private static final int DEFAULT_CAPACITY = 10;
   * 每次扩容为增加原来的一半
   * */

  public static void main(String[] args) {
    test1();
  }

  /**
   * 迭代器
   */
  public static void test1() {
    List<String> list = new ArrayList<>();
    list.add("老干妈");
    list.add("老干爹");
    Iterator<String> it = list.iterator();

    while(it.hasNext()) {
      String s = it.next();
      // 顺便试一下删除
      if("老干妈".equals(s)) {
        it.remove();
      }
      System.out.println(s);
    }
    System.out.println(list);
  }
}
