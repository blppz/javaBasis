package grammar;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/16 15:22
 */
public class G27InnerClass {
  /**
   * 内部类分类：在Java中内部类主要分为成员内部类(非静态内部类、静态内部类)、匿名内部类、局部内部类
   *
   * 1.非静态内部类：
   * i.非静态内部类必须寄存在一个外部类对象里。(注意：是外部类对象！！！)
   *   因此，如果有一个非静态内部类对象那么一定存在对应的外部类对象。
   *   非静态内部类对象单独属于外部类的某个对象。
   * ii.非静态内部类可以直接访问外部类的成员，
   *   但是外部类不能直接访问非静态内部类成员。(注意：是直接，所以很显然的是，我可以new Inner来进行访问)
   * iii.非静态内部类不能有静态方法、静态属性和静态初始化块。
   * iv.外部类的静态方法、静态代码块不能访问非静态内部类，
   *   包括不能使用非静态内部类定义变量、创建实例。
   *
   * 2.静态内部类：
   * i.当一个静态内部类对象存在，并不一定存在对应的外部类对象。
   *   因此，静态内部类的实例方法不能直接访问外部类的实例方法。
   * ii.静态内部类看做外部类的一个静态成员。 因此，外部类的方法中可以通过：
   *   “静态内部类.名字”的方式访问静态内部类的静态成员，通过 new 静态内部类()访问静态内部类的实例。
   */


  public static void main(String[] args) {

    //
    Outer outer = new Outer();
    outer.say();
    System.out.println("---------------");

    // 创建非静态内部类
    // 因为Inner是非静态的，所以要先有外部类，才能new内部类
    Outer.Inner inner = new Outer().new Inner();
    inner.sayOuterName();

    System.out.println("-------------------");
    // 创建静态内部类
    Outer.StaticInner inner2 = new Outer.StaticInner();
    inner2.sayHello();
    Outer.StaticInner.sayHello2();
    System.out.println(Outer.StaticInner.name);
  }
}

class Outer {

  private String name = "希希";

  Inner inner = new Inner();
  public void say() {
    inner.sayOuterName();
  }

  class Inner {
    String name = "嘻嘻";

    public void sayOuterName() {
      String name = "西西";
      System.out.println(Outer.this.name);
      System.out.println(this.name);
      System.out.println(name);
    }
  }

  static class StaticInner {
    public static String name = "老干妈";
    public void sayHello() {
      System.out.println("hello");
    }
    public static void sayHello2() {
      System.out.println("hello2");
    }
  }
}
