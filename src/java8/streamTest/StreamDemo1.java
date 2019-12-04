package java8.streamTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/11/29 19:47
 */
public class StreamDemo1 {
  /**
   * 四种创建Stream的方式
   */

  // 第一种，利用Collection
  @Test
  public void test1() {
    List<String> list = Arrays.asList("123","312","asdf");
    Stream<String> stream = list.stream();
    stream.forEach(System.out::println);
  }

  // 第二种，利用Arrays工具类stream方法
  @Test
  public void test2() {
    IntStream stream = Arrays.stream(new int[]{1, 2, 3});
    stream.forEach(System.out::println);
  }

  // 第三种，使用Stream.of方法
  @Test
  public void test3() {
    Stream<String> stream = Stream.of("aa", "bb", "asdf");
    stream.filter((s)->s.length()>3)
        .forEach(System.out::println);
  }

  // 第四种，创建无限流
  @Test
  public void test41() {
    Stream<Integer> iterate = Stream.iterate(0, (i) -> i + 2);
    iterate.limit(10).forEach(System.out::println);
  }

  // 创建无限流的第二种方式
  @Test
  public void test42() {
    Stream<Double> generate = Stream.generate(Math::random);
    //generate.forEach(System.out::println);
    generate.limit(10).forEach(System.out::println);
  }
}
