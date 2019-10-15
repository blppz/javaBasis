package grammar;

import javax.swing.plaf.ComponentUI;

/**
 * @Deacription 面向对象
 * @Author BarryLee
 * @Date 2019/10/14 21:55
 */
public class G11Object1 {
  /**
   * 面向过程和面向对象都是解决问题的一种思维方式
   * 宏观上可以使用面向对象去把握，微观上的处理仍然是面向过程
   * 他们是相辅相成的
   *
   * 类：在内存中是一些代码块
   * 对象：是类的实例
   *
   *
   * 抽象：抽出相同部分，进行归类
   */

  public static void main(String[] args) {
    HncuStud stud = new HncuStud();
    stud.age = 20;
    stud.name = "扣脚女子";

    Computer computer = new Computer();
    computer.brand = "华为";

    stud.computer = computer;
    stud.study();
  }
}

class HncuStud {
  int age;
  String name;
  Computer computer;

  public HncuStud() {
  }

  public void study() {
    System.out.println(name + ", " + age + ", 使用" + computer + "在学习");
  }
}
class Computer {
  String brand;
}