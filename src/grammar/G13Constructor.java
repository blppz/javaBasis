package grammar;

/**
 * @Deacription 构造方法
 * @Author BarryLee
 * @Date 2019/10/15 10:38
 */
public class G13Constructor {
  /**
   * 构造方法有返回值，返回值是一个对象，但是为什么不在构造方法声明呢
   * 因为所有构造方法都一定有这个返回值，所以没有必要写，且这样可以更轻易的区分与别的方法
   *
   * 构造方法其实也是一个方法来的
   *
   * 如果我们自己没有写构造方法，编译器会自动加上一个无参构造方法
   * 构造方法名必须和类型一致
   *
   * 构造方法也经常需要重载，并且和普通方法是一样一样的
   */

  private String name;
  private int age;
  public G13Constructor(String name) {
    super();
    this.name = name;
  }
  public G13Constructor(String name, int age) {
    //super();
    //this.age = age;
    //this.name = name;

    //或者写成
    this(name); // 这句是构造器的调用，必须放在第一句
    this.age = age;
  }

  public static void main(String[] args) {
    G13Constructor g = new G13Constructor("老干妈");
    System.out.println(g.name);

    G13Constructor g2 = new G13Constructor("老干爹", 34);
    System.out.println(g2.name + ", " + g2.age);
  }
}
