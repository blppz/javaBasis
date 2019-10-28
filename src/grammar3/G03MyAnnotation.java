package grammar3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/27 21:31
 *
 * target: 注解可以放哪
 * Retention: 有效期
 *
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface G03MyAnnotation {
  // value - 参数名
  // String - 参数类型
  //String value() default "老干妈";
  String value();
  int[] age();
}

class TestAnnotation {

  //@G03MyAnnotation("123")
  @G03MyAnnotation(value="laoganma", age={1,2})
  public void test() {
  }
}