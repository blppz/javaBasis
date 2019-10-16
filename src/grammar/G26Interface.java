package grammar;

/**
 * @Deacription 接口
 * @Author BarryLee
 * @Date 2019/10/16 14:34
 */
public interface G26Interface {
  /**
   * 接口与抽象类的区别？
   * 抽象类还可以有具体的实现，但接口中所有的方法都是抽象的，它分离了规范和具体的实现
   *
   * 接口本质
   * 接口的本质是锲约、是规范，大家都要遵守的
   * 面向对象的精髓，是对对象的抽象，最能体现这一点的就是接口。
   * 为什么我们讨论设计模式都只针对具备了抽象能力的语言(比如C++、Java、C#等)，
   * 就是因为设计模式所研究的，实际上就是如何合理的去抽象
   *
   * 接口可以是多继承的，但普通类只能是单继承的
   *
   * 如果别人问：Java有没有多继承
   * 答：Java的类没有多继承，但是Java的接口有多继承
   *
   * 接口是可以多实现的
   *
   *
   * 几个要点
   * 1.子类通过implements来实现接口中的规范。
   * 2.接口不能创建实例，但是可用于声明引用变量类型。
   * 3.一个类实现了接口，必须实现接口中所有的方法，并且这些方法只能是public的。
   * 4.JDK1.7之前，接口中只能包含静态常量、抽象方法，不能有普通属性、构造方法、普通方法。
   * 5.JDK1.8后，接口中包含普通的静态方法。
   *
   *
   * 接口与面向接口编程
   * 接口的概念如上，比较简单
   * 面向接口编程：软件设计中最为困难的就是需求变化，而需求的变化体现在具体实现的变化，
   * 所以我们需要一定的规范，这种规范就是接口，项目中最为稳定的东东，面向接口编程，以不变应万变
   * 同时，面向接口编程而不是面向具体实现编程，可以使得模块之间解耦，提高系统的可拓展性、可维护性
   *
   */

  // 下面着两种定义“变量方式是一样一样的”，因为默认就是public static final
  int a = 10;
  public static final int b = 12;

  // 下面这两个方法定义是一样的，因为默认就是public abstract
  //void eat();
  public abstract void eat();

  /**
   * 接口中的静态方法
   */
  public static void testStaticFun() {
    System.out.println("我是接口中的静态方法");
  }
}

class TestG26Interface implements G26Interface{

  @Override
  public void eat() {
    System.out.println("傻孩子，吃饭啦" + b + a);
  }

  public static void main(String[] args) {
    TestG26Interface f = new TestG26Interface();

    f.eat();
  }
}