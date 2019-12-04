package java8.lambdaTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/11/29 13:03
 */
public class LambdaDemo2 {
  // consumer
  @Test
  public void test1() {
    f1("11", (e) -> System.out.println(e));
  }
  public <T> void f1(T t, Consumer<T> consumer) {
    consumer.accept(t);
  }

  // supplier
  @Test
  public void test2() {
    List<Integer> list = getList(10, () -> (int) (Math.random() * 100));
    System.out.println(list);
  }
  // //需求：产生指定个数的整数，并放入集合中
  public List<Integer> getList(Integer n, Supplier<Integer> supplier) {
    List list = new ArrayList();
    for(int i = 0; i < n; i++) {
      list.add(supplier.get());
    }
    return list;
  }

  @Test
  public void test3() {
    //String string = handleString("\t\t我大xx萌萌哒   ", (str) -> str.trim());
    String string = handleString("\t\t我大xx萌萌哒   ", String::trim);
    System.out.println(string);
  }
  // 需求：用于处理字符串
  public String handleString(String str, Function<String, String> fun) {
    return fun.apply(str);
  }

  @Test
  public void test4() {
    List<String> list = Arrays.asList(
        "aaaa","ccccccc",
        "bbb","asdf", "a"
    );
    list = filterList(list,(str) -> str.length()>3);
    System.out.println(list);
  }
  //需求：将满足条件的字符串，放入集合中
  public List<String> filterList(List<String> list, Predicate<String> pre) {
    List<String> res = new ArrayList<>();
    for(int i = 0; i<list.size(); i++) {
      if(pre.test(list.get(i))) {
        res.add(list.get(i));
      }
    }
    return res;
  }
}
