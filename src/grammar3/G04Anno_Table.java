package grammar3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/27 22:11
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface G04Anno_Table {
  // 表名
  String value();
}
