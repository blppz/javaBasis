package grammar3;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Objects;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/25 22:30
 */
public class G01Reflect {
  /**
   * 反射：把Java类中的各种结构（属性、方法、构造器、类名）映射成一个个的Java对象
   *
   * 三种方式获取Class对象：
   * 1.类.class()
   * 2.对象.getClass
   * 3.Class.forName(完整类名 -> 包名.类型)
   */
  // 获取
  @Test
  public void test1() {
    // 拿到类
    Class<Student> clazz1 = Student.class;
    Student student = new Student();
    System.out.println(clazz1);
    Class<? extends Student> clazz2 = student.getClass();
    System.out.println(clazz2);

    // 推荐方式，为什么推荐？
    // 灵活、低耦合
    // 灵活可以理解，但是低耦合呢？
    // 一般面向接口编程，我们穿过类的可能是一个子类，我们可以接收一个返回值，面向它的父类编程
    try {
      Class<?> clazz3 = Class.forName("grammar3.Student");
      System.out.println(clazz3);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
  // 创建对象
  @Test
  public void test2() {
    try {
      Class<?> clazz = Class.forName("grammar3.Student");

      // 创建对象
      Student student = (Student) clazz.newInstance();
      System.out.println(student);

      // 访问属性
      // 使用getField访问私有属性报错：java.lang.NoSuchFieldException
      // Field age = clazz.getField("age");
      // 使用getDeclaredField可以访问私有属性，但是这个属性并不是值
      // 所以可以使用getDeclaredFields获取所有的属性
      Field age = clazz.getDeclaredField("age");
      //System.out.println(age);
      Field[] fields = clazz.getDeclaredFields();
      for(Field f: fields) {
        System.out.println(f.getName());
      }

      // 获取所有方法
      Method[] methods = clazz.getDeclaredMethods();
      System.out.println("--------------");
      for(Method method: methods) {
        System.out.println(method.getName());
      }
      System.out.println("--------------");

      // 调用方法使用：invoke(), 怎么获取返回值？直接强转
      Method setName = clazz.getDeclaredMethod("setName", String.class);
      setName.invoke(student, "老干妈");
      Method getName = clazz.getDeclaredMethod("getName");
      String name = (String) getName.invoke(student);
      System.out.println(name);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
