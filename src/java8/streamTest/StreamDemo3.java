package java8.streamTest;

import java8.domain.Employee;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/11/30 14:44
 */
public class StreamDemo3 {
  // 自然排序 -- Comparable
  @Test
  public void test1() {
    Arrays.stream(new Integer[]{12,20,3,40,99,0})
        .sorted()
        .forEach(System.out::println);
  }

  private List<Employee> list;
  @Before
  public void before() {
     list = Arrays.asList(
        new Employee(1,"老干妈",23,333.33),
        new Employee(2,"老干爹",13,1333.33),
        new Employee(3,"肉丝",203,2333.33),
        new Employee(4,"jack",123,3333.33),
        new Employee(5,"tom",230,4333.33)
    );
  }
  // 定制排序
  @Test
  public void test2() {
    list.stream()
        .sorted((o1 ,o2) -> {
          if(o1.getAge() == o2.getAge()){
            return o1.getName().compareTo(o2.getName());
          }else{
            return Integer.compare(o1.getAge(), o2.getAge());
          }
        })
        .forEach(System.out::println);
  }

  // 工资最大值
  @Test
  public void test3() {
    Optional<Double> max = list.stream()
        .map(Employee::getSalary)
        .max(Double::compare);
    System.out.println(max.get());
  }
  // 工资最高的靓仔
  @Test
  public void test4() {
    Optional<Employee> max = list.stream()
        .max(Comparator.comparingDouble(Employee::getSalary));
    System.out.println(max);
  }

  // map-reduce , 规约, 这个也常用
  // 将名字都串成一个字符串
  @Test
  public void test5() {
    Optional<String> reduce = list.stream()
        .map(Employee::getName)
        .reduce((s1, s2) -> s1 + s2);
    System.out.println(reduce.get());
  }

  //
  @Test
  public void test6() {
    Map<Boolean, List<Employee>> collect = list.stream()
        .collect(Collectors.groupingBy((e) -> e.getSalary() > 300));
  }

  // 并行流
  @Test
  public void test7() {
    Optional<Employee> any = list.parallelStream()
        .filter((o1) -> o1.getSalary() > 19999)
        .findAny();
    System.out.println(any.isPresent()?any.get():"空空如也");
    System.out.println("---------------------");
    Instant start = Instant.now();
    Optional<Integer> reduce = Stream.iterate(0, (i) -> i + 1)
        .parallel()
        .limit(1000000000L)
        .reduce((o1, o2) -> o1 + o2);
    Instant end = Instant.now();
    System.out.println(reduce);
    System.out.println((end.getNano()-start.getNano())/1000);
  }

  @Test
  public void test8() {
    Instant start = Instant.now();
    long s = 0L;
    for(long i = 0; i<500000000000L; i++) {
      s += i;
    }
    Instant end = Instant.now();
    System.out.println(Duration.between(start,end).toMillis());
  }
  @Test
  public void test9() {
    Instant start = Instant.now();
    OptionalLong reduce = LongStream.rangeClosed(0, 100000000000L)
        .parallel().reduce(Long::sum);
    Instant end = Instant.now();
    System.out.println(Duration.between(start,end).toMillis());
    System.out.println(reduce);
  }

}
