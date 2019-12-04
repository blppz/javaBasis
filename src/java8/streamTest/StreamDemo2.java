package java8.streamTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/11/29 22:51
 */
public class StreamDemo2 {
  // 惰性加载：使用到这个流的数据的时候它才回去加载
  @Test
  public void test1() {
    List<String> list = Arrays.asList("aa","bbb","cccc","ddddd");
    Stream<String> stream = list.stream()
        .filter((str) -> {
          System.out.println("惰性加载");
          return str.length() > 3;
        });

    // 如果没有下面这种使用到流的情况，是不会进行加载的
    stream.forEach(System.out::println);
  }

  // 短路：找到了所有满足条件的元素就不会再进行加载剩余的元素了
  // 有点像短路与 - 第一个为false后面的不用看、短路或 - 第一个为true后面的就不用看了
  @Test
  public void test2() {
    Stream<String> stream = Stream.of("aa", "bbb", "cccc", "dddd")
        .filter(str -> {
          System.out.println("短路");
          return str.length() > 2;
        })
        .limit(2);
    stream.forEach(System.out::println);
  }

  // 测试skip - 跳过部分元素
  @Test
  public void test3() {
    // 创建无限流，跳过前面两个，打印三个元素
    Stream.iterate(0, i->i+2)
        .skip(2)
        .limit(3)
        .forEach(System.out::println);
  }

  // 测试distinct - 去重
  @Test
  public void test4() {
    Stream<String> stream = Stream.of("1", "2", "2", "1", "6").distinct();
    stream.forEach(System.out::println);
  }

  // map - 映射，将字符全部变成大写
  @Test
  public void test5() {
    // 字符串数组
    String[] strs = {"aa", "bb", "cc"};
    Stream<String> stream = Stream.of(strs)
        .map(String::toUpperCase);
    stream.forEach(System.out::println);
  }

  // test6 与 7进行对比，test6中的map之后的返回值有两层，而test7中的flatMap的返回值是只有一层stream
  // 说明flapMap相当于List的addAll方法 -- 是一种平铺的方法
  @Test
  public void test6() {
    String[] strs = {"aa", "bb", "cc"};
    Stream<Stream> stream = Stream.of(strs)
        .map(StreamDemo2::charStream);
    stream.forEach(s -> {
      s.forEach(System.out::println);
    });
  }
  @Test
  public void test7() {
    String[] strs = {"aa", "bb", "cc"};
    Stream stream = Stream.of(strs)
        .flatMap(StreamDemo2::charStream);
    stream.forEach(System.out::println);
  }
  public static Stream charStream(String s) {
    List<Character> list = new ArrayList<>();
    for(int i = 0; i < s.length(); i++) {
      list.add(s.charAt(i));
    }
    return list.stream();
  }
}
