package grammar3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/27 22:14
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface G04Anno_Field {
  String name();
  String type();
  int length();
}
