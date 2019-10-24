package grammar2;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/22 9:40
 */
public class G22LambdaTest1 {

  // 如果是要return值：like = (a, b) -> a+ b;
  // 是不需要写return关键字的

  public static void main(String[] args) {
    Like like = new MyLike();
    like.like();

    like = new Like() {
      @Override
      public void like() {
        System.out.println("匿名内部类like");
      }
    };
    like.like();

    like = () -> System.out.println("lambda like");
    like.like();
  }
  static interface Like {
    void like();
  }
  static class MyLike implements Like {
    @Override
    public void like() {
      System.out.println("静态内部类like");
    }
  }
}
