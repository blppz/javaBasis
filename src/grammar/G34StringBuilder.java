package grammar;

import javax.swing.*;

/**
 * @Deacription StringBuilder
 * @Author BarryLee
 * @Date 2019/10/17 8:45
 */
public class G34StringBuilder {
  /**
   * StringBuilder是可变的字符序列
   * 内容变更的时候hashCode没变
   *
   * StringBuilder和StringBuffer之间的区别
   * StringBuilder线程不安全、效率高
   * StringBuffer线程安全，效率低
   * 但他们用法上是一致的，所以会一个就OK了
   *
   * 可以进行链式调用（连着调用StringBuilder的方法）
   * 原理是这些方法都会在执行完毕之后返回this
   */
  public static void main(String[] args) {
    StringBuilder sb1 = new StringBuilder("123");
    for(int i = 0; i < 26; i++) {
      //sb1.append((char)(97+i));
      sb1.append((char)('a'+i));
    }

    System.out.println(sb1);


    ////////////////////
    System.out.println("----------------------");
    testStringBuilder();
  }

  /**
   * 测试String和StringBuilder耗时耗空间
   */
  public static void testStringBuilder() {
    long memory1 = Runtime.getRuntime().freeMemory();
    long time1 = System.currentTimeMillis();
    String s = "";
    for(int i = 0; i < 5000; i++) {
      s += i;
    }
    long memory2 = Runtime.getRuntime().freeMemory();
    long time2 = System.currentTimeMillis();
    System.out.println(memory1 - memory2);
    System.out.println(time2 - time1);


    System.out.println("----------------------");
    memory1 = Runtime.getRuntime().freeMemory();
    time1 = System.currentTimeMillis();
    StringBuilder sb = new StringBuilder("");
    for(int i = 0; i < 5000; i++) {
      sb.append(i);
    }
    memory2 = Runtime.getRuntime().freeMemory();
    time2 = System.currentTimeMillis();
    System.out.println(memory1 - memory2);
    System.out.println(time2 - time1);
  }
}
