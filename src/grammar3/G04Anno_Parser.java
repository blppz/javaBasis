package grammar3;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/27 22:11
 */
public class G04Anno_Parser {
  public static void main(String[] args) throws ClassNotFoundException {
    Class<?> clazz = Class.forName("grammar3.G04Anno_Student");

    // 1.获取类的所有注解
    Annotation[] annotations = clazz.getAnnotations();
    for(Annotation a: annotations) {
      System.out.println(a);
    }
    System.out.println("------------");

    // 2.获取类的指定的注解
    G04Anno_Table clazzAnno = clazz.getAnnotation(G04Anno_Table.class);
    System.out.println(clazzAnno);
    System.out.println("------------");

    // 3.获取参数的注解
    Field[] declaredFields = clazz.getDeclaredFields();
    for(Field f: declaredFields) {
      Annotation[] annotations1 = f.getAnnotations();
      for(Annotation an: annotations1) {
        System.out.println(an);
      }
    }
  }
}
