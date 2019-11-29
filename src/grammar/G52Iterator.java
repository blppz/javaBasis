package grammar;

import org.junit.Test;

import java.io.IOException;
import java.util.*;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/19 20:57
 */
public class G52Iterator {
  /**
   * 这里是  迭代器专场
   * list, set, map(这个不一样)
   * 其实是一样的，因为接口是同一个
   */
  @Test
  public void testList() {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    Iterator<Integer> iterator = list.iterator();
    while(iterator.hasNext()) {
      Integer res = iterator.next();
      System.out.println(res);
    }
  }

  @Test
  public void testSet() {
    Set<Integer> set = new HashSet<>();
    set.add(1);
    set.add(2);
    set.add(3);
    // 酱紫写也行
    for(Iterator<Integer> it = set.iterator(); it.hasNext();) {
      Integer next = it.next();
      System.out.println(next);
    }
  }

  @Test
  public void testMap() {
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "aa");
    map.put(2, "bb");
    map.put(3, "cc");
    map.put(4, "dd");

    Set<Map.Entry<Integer, String>> entries = map.entrySet();
    for(Map.Entry entry: entries) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
}
