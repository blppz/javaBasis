package grammar;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/16 16:11
 */
public class G28AnonymousInnserClass {

  // 这个方法需要一个G28Interface
  public static void fun(G28Interface g) {
    g.aa();
  }

  public static void main(String[] args) {
    // 现在我要调用fun方法，但是我只会调用一次，并且这个方法需要给他提供一个G28Interface接口的实现
    // 所以这里使用匿名内部类
    // fun(() -> System.out.println("你成功调用了aa方法")); // 这是lambda表达式写法
    fun(new G28Interface() {
      @Override
      public void aa() {
        System.out.println("你成功调用了aa方法");
      }
    });
  }
}

// 声明这个接口来测试匿名内部类
interface G28Interface {
  void aa();
}