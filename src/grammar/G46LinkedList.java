package grammar;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Deacription 链表使用
 * @Author BarryLee
 * @Date 2019/10/18 11:51
 */
public class G46LinkedList {
  public static void main(String[] args) {
    LinkedList<String> link = new LinkedList<>();
    link.add("老干妈");
    link.add("老干爹");
    link.add("葡萄干");
    link.addFirst("华为");
    System.out.println(Arrays.toString(link.toArray()));

    link.remove(1);
    System.out.println(Arrays.toString(link.toArray()));

    link.remove("华为");
    System.out.println(Arrays.toString(link.toArray()));

    // 空参，移除的是头节点
    link.remove();
    System.out.println(Arrays.toString(link.toArray()));

    link.clear();
    System.out.println(link.size() + ", " + link.isEmpty());

  }
}
