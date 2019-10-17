package grammar;

/**
 * @Deacription 泛型
 * @Author BarryLee
 * @Date 2019/10/17 20:31
 */
public class G42Genericity {
  /**
   * 我的博客：https://blog.csdn.net/qq_38238041/article/details/79836810
   * 泛型的本质就是“数据类型的参数化”。
   * 我们可以把“泛型”理解为数据类型的一个占位符(形式参数)，
   * 即告诉编译器，在调用泛型时必须传入实际类型。
   *
   * 泛型的定义：其实，泛型无非就是通过<>定义了一个形式参数，
   * 专门用于接收具体的引用类型。在使用时，一定要传递对应的实际参数类型。
   */
  public static void main(String[] args) {
    MySet<String> set = new MySet<>(3);
    set.set("老干妈", 0);
    System.out.println(set.get(0));
    //set.set(123, 1); // 有了泛型，这里就报错了
  }
}

class MySet<E> {
  private Object[] obs;
  public MySet(int length) {
    obs = new Object[length];
  }
  public void set(E e, int index) {
    obs[index] = e;
  }
  public E get(int index) {
    return (E)obs[index];
  }
}