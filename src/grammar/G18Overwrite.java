package grammar;

import java.io.IOException;

/**
 * @Deacription 重写
 * @Author BarryLee
 * @Date 2019/10/15 15:09
 */
public class G18Overwrite {

  /**
   * 方法重写需要注意的几个点
   * 1.“==”：方法名、形参列表相同。
   * 2.“≤”：返回值类型和声明异常类型，子类小于等于父类。
   *  （什么是小于：例如父类返回一个Persion，那子类只能返回Persion或Persion的子类）
   * 3.“≥”：访问权限，子类大于等于父类。
   */

  public static void main(String[] args) throws IOException {
    G18Student student = new G18Student();
    student.study();
    student.eat();
  }
}

// 父类
class G18Person {
  String name;
  public G18Person study() throws Exception {
    System.out.println("学习");
    return this;
  }
  public void eat() {
    System.out.println("吃饭");
  }
}

// 子类
class G18Student extends G18Person {
  String name;
  public G18Student study() throws IOException {
    System.out.println("敲代码");
    return this;
  }
}