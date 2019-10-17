package grammar;

/**
 * @Deacription 枚举的基本用法
 * @Author BarryLee
 * @Date 2019/10/17 15:47
 */
public class G39Enum {


  /**
   * 所有的枚举类型隐性地继承自 java.lang.Enum。
   * 枚举实质上还是类!而每个被枚举的成员实质就是一个枚举类型的实例，
   * 他们默认都是public static final修饰的。可以直接通过枚举类型名使用它们。
   *
   * 1.当你需要定义一组常量时，可以使用枚举类型。
   * 2.尽量不要使用枚举的高级特性，事实上高级特性都可以使用普通类来实现，
   *   没有必要引入枚举，增加程序的复杂性!
   */

  public static void main(String[] args) {
    Season s = Season.AUTUMN;
    switch (s) {
      case SPRING:
        System.out.println("春天来了，交配的季节");
        break;
      case SUMMER:
        System.out.println("夏天来了，吃雪糕的季节");
        break;
      case AUTUMN:
        System.out.println("秋天来了，捡垃圾的季节");
        break;
      case WINTER:
        System.out.println("冬天来了，冬眠的季节");
        break;
    }
  }
}
enum Season {
  SPRING, SUMMER, AUTUMN, WINTER
}
