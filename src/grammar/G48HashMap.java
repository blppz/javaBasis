package grammar;

import java.util.HashMap;
import java.util.Map;

import java.util.Map.Entry;

import java.util.Set;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/18 16:44
 */
public class G48HashMap {

  /**
   * HashMap的使用及原理都要十分清楚
   *
   * 底层存储结构是一个哈希表
   * 1.计算Key的hashCode
   * 2.然后根据这个hashCode算出在桶中的位置hash值(0 - 15)
   * 3.放到链表(单向的)，串起来【hash、key、value、next】
   * 4.JDK8之后是链表长度大于8就变成了红黑树
   *
   * 计算hash值的方法：hashCode & (数组长度 - 1)
   *
   * 所以为什么hashMap初始数组长度为16
   *  hashcode是一个整数，我们需要将它转化成[0, 数组长度-1]的范围。
   *  我们要求转化后的hash值尽量均匀地分布在[0,数组长度-1]这个区间，减少“hash冲突”
   *  一种简单和常用的算法是(相除取余算法)：hash值 = hashcode%数组长度
   *  这种算法可以让hash值均匀的分布在[0,数组长度-1]的区间。
   *  早期的HashTable就是采用这种算法。
   *  但是，这种算法由于使用了“除法”，效率低下。JDK后来改进了算法。
   *  首先约定数组长度必须为2的整数幂，这样采用位运算即可实现取余的效果：（值不一样，但目的一样）
   *  hash值 = hashcode&(数组长度-1)
   *
   *  扩容问题
   *   HashMap的位桶数组，初始大小为16。实际使用时，显然大小是可变的。
   *   如果位桶数组中的元素达到(0.75*数组 length)， 就重新调整数组大小变为原来2倍大小
   *
   * 遍历用什么方法？
   * 看需求吧
   * 如果key、value都是需要的，最好就是使用entrySet，因为只遍历了一次
   * 如果是keySet，在拿到所有的key之后，还需要根据key去拿value，效率肯定低了
   * 如果是values，那就拿不到key了，这个用的少
   * 另外，lambda表达式也是OK的，而且用法更简单，只是需要JDK版本8+
   */

  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
    map.put("1001", "老干妈");
    map.put("1002", "老干爹");
    map.put("1003", "老炮鸭");
    map.put("1004", "老人家");
    //test1(map);
    System.out.println("========");
    test21(map);
    System.out.println("========");
    test22(map);
    System.out.println("========");
    test23(map);
    System.out.println("========");
    test24(map);
  }
  // 测试常用方法
  public static void test1(Map map) {
    System.out.println(map.size());
    System.out.println(map);
    map.remove("1002");
    System.out.println(map);
  }


  //测试遍历
  /**
   * 1.values
   */
  public static void test21(Map map) {

    for(Object o: map.values()) {
      System.out.println(o);
    }
  }
  /**
   * 2.keySet
   */
  public static void test22(Map map) {
    Set<String> keys = map.keySet();
    for(String s: keys) {
      System.out.println(s + ": " +map.get(s));
    }
  }

  /**
   * 3.entry
   */
  public static void test23(Map map) {
    Set<Entry<String, String>> set = map.entrySet();
    for(Entry<String, String> entry: set) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }

  /**
   * 4.forEach
   */
  public static void test24(Map map) {
    map.forEach((key, value) -> System.out.println(key + ": " + value));
  }
}
