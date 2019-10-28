package grammar3;

import javassist.*;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/28 15:01
 */
public class G08javassist {
  /**
   * 使用javassist生成一个新的类
   * 源码级别的操作
   */
  @Test
  public void test1() throws Exception {
    ClassPool pool = ClassPool.getDefault();
    CtClass clazz = pool.makeClass("grammar3.Student");

    CtField ageField = CtField.make("private int age;", clazz);
    CtField nameField = CtField.make("private String name;", clazz);
    clazz.addField(ageField);
    clazz.addField(nameField);

    CtMethod getAge = CtMethod.make("public void getAge() {return age;}", clazz);
    CtMethod setAge = CtMethod.make("public void setAge(int age){this.age = age;}", clazz);

    clazz.addMethod(getAge);
    clazz.addMethod(setAge);

    CtConstructor constructor = new CtConstructor(new CtClass[]{CtClass.intType, pool.get("java.lang.String")}, clazz);
    constructor.setBody("{this.age=age; this.name=name;}");
    clazz.addConstructor(constructor);

    // 写出到磁盘
    clazz.writeFile("e:/test/testJavassist");
    System.out.println("success");
  }

  /**
   * 在方法执行前嵌入代码
   */
  @Test
  public void test2() throws Exception {
    ClassPool pool = ClassPool.getDefault();
    CtClass ctClass = pool.makeClass("grammar3.Student");

    CtMethod ctSayHi = ctClass.getDeclaredMethod("sayHi");
    ctSayHi.insertBefore("System.out.println(\"before you\");");

    Class<?> clazz = ctClass.toClass();
    Method sayHi = clazz.getDeclaredMethod("sayHi");
    sayHi.invoke(clazz);
  }
}
