package grammar;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/17 21:15
 */
public class G43Collection {
  public static void main(String[] args) {
    Collection<String> c = new ArrayList<>();
    System.out.println(c.isEmpty()); // just test ok ?
    c.add("老干妈");
    c.add("老干爹");
    c.add("雷神");
    c.add("诡计之神");
    System.out.println(c);
    c.remove("老干爹");
    System.out.println(c);
    System.out.println(c.contains("雷神"));
    System.out.println(c.size());
    System.out.println(c.isEmpty());

    System.out.println("------------------");
    // 这个方法取本容器和容器o中都包含的元素，移除非交集的元素
    Collection<String> o = new ArrayList<>();
    o.add("雷神");
    c.retainAll(o);
    System.out.println(c); // 现在只剩下一个雷神了
    System.out.println(o);
    System.out.println("------------------");

    c.removeAll(c);
    System.out.println(c.isEmpty());
  }
}
