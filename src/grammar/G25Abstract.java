package grammar;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/16 14:22
 */
public abstract class G25Abstract {
  /**
   * 抽象类的意义：
   * 为子类提供统一的、规范的模板，子类必须实现相关的抽象方法
   *
   * 抽象类的特点：
   * 1.有抽象方法的类只能定义成抽象类
   * 2.抽象类不能实例化，即不能用new来实例化抽象类。
   * 3.抽象类可以包含属性、方法、构造方法。但是构造方法不能用来new实例，只能用来被子类调用。
   * 4.抽象类只能用来被继承。
   * 5.抽象方法必须被子类实现。
   */

  public abstract void eat();

  public int add(int a, int b) {
    System.out.println(a + b);
    return a + b;
  }

  public G25Abstract() {
    // do sth
  }

  public static void main(String[] args) {

  }
}