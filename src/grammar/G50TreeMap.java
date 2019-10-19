package grammar;

import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Deacription
 * @Author BarryLee
 * @Date 2019/10/19 19:49
 */
public class G50TreeMap {

  /**
   * TreeMap是线程安全的，但是效率低
   * 它的底层是红黑树实现的
   */
  public static void main(String[] args) {
    Map<String, String> map = new TreeMap<>();
    map.put("1001", "被子");
    map.put("1002", "大舜");
    map.put("2004", "软件园");
    for(Map.Entry<String, String> entry: map.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
    System.out.println("-------------------");

    Map<G50Persion, String> map2 = new Hashtable<>();
    G50Persion p1 = new G50Persion(1, "张三", 4000.1);
    G50Persion p2 = new G50Persion(2, "李四", 5000.1);
    G50Persion p3 = new G50Persion(3, "王五", 6000.1);
    map2.put(p1, "他是个懒人");
    map2.put(p2, "他工作不积极");
    map2.put(p3, "他工作还不错");
    for(Map.Entry<G50Persion, String> entry: map2.entrySet()) {
      System.out.println(entry.getKey() + ": "  + entry.getValue());
    }
  }
}

class G50Persion implements Comparable<G50Persion> {
  private Integer id;
  private String name;
  private Double salary;
  public G50Persion() {
  }
  public G50Persion(Integer id, String name, Double salary) {
    this.id = id;
    this.name = name;
    this.salary = salary;
  }

  @Override
  public int compareTo(G50Persion o) {
    return this.id - o.id;
  }

  @Override
  public String toString() {
    return "G50Persion{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", salary=" + salary +
        '}';
  }
}
