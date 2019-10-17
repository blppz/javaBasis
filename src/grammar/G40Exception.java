package grammar;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/17 15:59
 */
public class G40Exception {
  /**
   * Java是采用面向对象的方式来处理异常的。
   * 处理过程
   * 1.抛出异常：在执行一个方法时，如果发生异常，则这
   *   个方法生成代表该异常的一个对象，停止当前执行路径，
   *   并把异常对象提交给JRE
   * 22.捕获异常：JRE得到该异常后，寻找相应的代码来处理该
   *   异常。JRE在方法的调用栈中查找，从生成异常的方法开
   *   始回溯，直到找到相应的异常处理代码为止。
   *
   * 常见运行时异常
   * ClassCastException
   * ArithmeticException
   * StakeOverFloatException
   * ArrayIndexOutOfBandsException
   * CalssNotFondException
   * IllegalArgumentException
   * NumberFormatException
   *
   */

  public static void main(String[] args) {
    try {
      int a = 1;
      int b = 0;
      //System.out.println(a/b);
    } catch (Exception e) {
      System.out.println(e);
      return;
    } finally {
      System.out.println("finally");
    }

    IlleagelAgePersionTest persion = new IlleagelAgePersionTest();
    persion.setAge(-10);
  }
}

class IlleagelAgePersionTest {
  private int age ;
  public void setAge(int age) {
    if(age < 0) {
      throw new IllegelAgeException("年龄不能为负数");
    }
    this.age = age;
  }
}

// 下面测试自定义异常
class IllegelAgeException extends RuntimeException{

  public IllegelAgeException() {
  }

  public IllegelAgeException(String e) {
    super(e);
  }
}