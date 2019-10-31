package grammar;

import static java.lang.Math.PI;

/**
 * @Deacription 演示静态导入
 * @Author BarryLee
 * @Date 2019/10/15 14:27
 */
public class G17StaticImport {

  /**
   * 静态导入，如果用*，对编译速度会有一点点影响，但是基本可以忽略，对运行时速度不会影响
   *
   * 如果出现一个类中需要导入多个相同名字的类的时候，可以使用直接使用的方法：new java.lang.Data ...
   */

  public static void main(String[] args) {
    System.out.println(PI);
  }
}
