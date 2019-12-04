package java8.lambdaTest;

import java8.intefa.MyInte1;
import java8.intefa.MyInte2;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/11/28 21:32
 */
public class LambdaDemo {

  private List<Employee> list = Arrays.asList(
    new Employee("张三",28, 3000.99),
    new Employee("李四",18, 2000.99),
    new Employee("王五",48, 9000.99),
    new Employee("赵六",18, 99000.99),
    new Employee("田七",98, 14000.99)
  );

  /**
   * 一、调用collections.sort() 方法， 通过定制排序比两Employee （ 先按年龄比， 年龄相同按姓名比） ，
   *    使用Lambda 作为参数传递。
   */
  @Test
  public void test1() {
    Collections.sort(list, (e1,e2) -> {
      if(e1.getAge().equals(e2.getAge())) {
        return e1.getName().compareTo(e2.getName());
      }else {
        return Integer.compare(e1.getAge(), e2.getAge());
      }
    });
    for(Employee e: list) {
      System.out.println(e);
    }
  }

  /**
   * 二、
   *  （1）声明函数式接口， 接口中声明抽象方法， public string getvalue(string str);
   *  （2）声明类TestLambda ， 类中编写方法使用接口作为参数， 将一个字符串转换成大写，并作为方法的返回值。
   *   3）再将一个字符串的第2 个和第4 个索引位置进行截取子串。
   */
  @Test
  public void test2() {
    //testString("asdfasdfJJkl", (str) -> str.toUpperCase());
    String s = testString("asdfasdfJJkl", String::toUpperCase);
    System.out.println(s);
  }
  public String testString(String str, MyInte1 inte1) {
    return inte1.getValue(str);
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
    long res = addFun(100L, 200L, Long::sum);
    System.out.println(res);
    res = addFun(100L, 200L, (a, b) -> a * b);
    System.out.println(res);
  }
  public long addFun(long a, long b, MyInte2<Long, Long> myInte2) {
    return myInte2.add(a, b);
  }

  @Test
  public void test() {
    int a = 10;
    Runnable r = () -> System.out.println(a);
    //a++;
    r.run();
    System.out.println(a);
  }
}
