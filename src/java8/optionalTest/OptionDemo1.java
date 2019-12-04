package java8.optionalTest;

import java8.domain.Goddess;
import java8.domain.Man;
import java8.domain.NewMan;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.Optional;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/11/30 21:52
 */
public class OptionDemo1 {

  // 并不是每个男人心中都有一个女神，但是每一个女神都有一个名字
  // 那么我们如何防止空指针异常呢
  @Test
  public void test1() {
    // 1.使用传统方式
    System.out.println(getGoddessName1(null));
    // 2.使用Optional
    Optional<NewMan> op = Optional.ofNullable(null);
    System.out.println(getGoddessName2(op));
  }
  public String getGoddessName2(@NotNull Optional<NewMan> op) {
    return op.orElse(new NewMan())
        .getGoddess()
        .orElse(new Goddess("波多老师"))
        .getName();
  }
  public String getGoddessName1(Man man) {
    if(man!=null && man.getGoddess()!=null) {
      return man.getGoddess().getName();
    }
    // 如果没有，就返回一个默认的女神名字
    return "苍老师";
  }

  @Test
  public void test() {
    // 如果给了null给他，就会装一个空的Optional对象，否则就是你放进去的对象
    Optional.ofNullable(123);

    // empty相当于一个空对象，就像一个长度为零的数组但不是null
    Optional<Object> empty = Optional.empty();

    // 自动装箱
    Optional<Integer> integer = Optional.of(1);
  }

  @Test
  public void test99() {
    int i = 0;
    //i = i++;
    i = ++i;
    System.out.println(i);
  }
}
