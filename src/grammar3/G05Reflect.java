package grammar3;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/27 22:36
 */
public class G05Reflect {
  /**
   * 1.什么是动态语言，什么是静态语言
   * 动态语言：程序在运行是可以改变程序结构或者变量的类型
   * 比如：python、JavaScript、ruby
   *
   * 2.Java、C、C++不是动态语言
   * 但是！Java有反射呀，这样她具备了一定的动态特性
   *
   * 3.对象是表示或者封装一些数据，一个类被加载之后，JVM会创建一个对应该类的一个Class对象
   * 类的整个结构信息会放到对应的Class对象中
   * 这个Class对象就像是一面镜子，通过这面镜子我们可以看到整个类全部信息
   *
   * 4.一个类只会被加载一次，形成一个Class对应的对象，多次获取只会返回同一个Class对象
   *
   * 5.field可以设置访问安全检查开关：setAccessAble，可以访问到私有属性，但是不建议使用
   * 但是，他作为一个安全检查机制，如果取消掉，可以提高反射的效率
   * 可以写一个Demo，反复调用student.getName()十亿次
   * （老高的结果就是普通方法2秒，不用setAccessAble的反射60秒，setAccessAble=true的14秒）
   *
   * 另外，性能方面后续可以学习cglig、javaassist
   *
   */

}
