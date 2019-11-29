package java8;

import org.junit.Test;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/11/29 16:32
 */
public class LambdaDemo3 {
  /**
   * 一、调用collections.sort() 方法， 通过定制排序比两Employee （ 先按年龄比， 年龄相同按姓名比） ，
   *    使用Lambda 作为参数传递。
   */
  private List<Employee> emps = Arrays.asList(
      new Employee("张三",28, 3000.99),
      new Employee("李四",18, 2000.99),
      new Employee("王五",48, 9000.99),
      new Employee("赵六",18, 99000.99),
      new Employee("田七",98, 14000.99)
  );
  @Test
  public void test1() {
    Collections.sort(emps, (o1,o2) -> {
      if(o1.getAge().equals(o2.getAge())) {
        return o1.getName().compareTo(o2.getName());
      }
      return Integer.compare(o1.getAge(),o2.getAge());
    });
    System.out.println(emps);
  }
  /**
   * 二、
   *  （1）声明函数式接口， 接口中声明抽象方法， public string getvalue(string str);
   *  （2）声明类TestLambda ， 类中编写方法使用接口作为参数， 将一个字符串转换成大写，并作为方法的返回值。
   *   3）再将一个字符串的第2 个和第4 个索引位置进行截取子串。
   */
  @Test
  public void test2() {
    Function<String, String> fun = String::toUpperCase;
    String string = fun.apply("sdfaJkljl");
    System.out.println(string);
  }

  /**
   * 三、
   * （1）声明一个带两个泛型的函数式接口， 泛型类型为<T,R> T 为参数， R 为返回值· ，
   * （2）接口中声明对应抽象方法． ，
   * （3）在TestLambda 类中声明方法， 使用接口作为参数， 计算两个long 型参数的和。
   * （4）再计算两个long 型参数的乘积。
   */
  @Test
  public void test3() {
    BiFunction<Long, Long, Long> biFun = Long::sum;
    Long apply = biFun.apply(12L, 123L);
    System.out.println(apply);
  }
}
