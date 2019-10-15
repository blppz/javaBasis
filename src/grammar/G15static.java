package grammar;

/**
 * @Deacription 静态
 * @Author BarryLee
 * @Date 2019/10/15 11:47
 */
public class G15static {

  /**
   * static
   * static修饰成员变量和方法从属于类
   * 普通变量和方法从属于对象
   */

  {
    System.out.println("代码块执行了");
  }

  public G15static() {
    System.out.println("构造器执行");
  }

  static {
    // 如果有父类的静态块，会先执行父级的静态块
    System.out.println("静态块执行");
  }

  public static void main(String[] args) {
    System.out.println("main执行");

    G15static s = new G15static();
  }
}
