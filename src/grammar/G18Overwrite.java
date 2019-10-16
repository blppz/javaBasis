package grammar;

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

  public static void main(String[] args) {
    G18Student student = new G18Student();
    student.study();
    student.eat();
  }
}

class G18Persion{
  String name;
  public G18Persion study() {
    System.out.println("学习");
    return this;
  }
  public void eat() {
    System.out.println("吃饭");
  }
}

class G18Student extends G18Persion{
  String name;
  public G18Student study() {
    System.out.println("敲代码");
    return this;
  }
}