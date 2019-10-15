package grammar;

/**
 * @Deacription 值传递
 * @Author BarryLee
 * @Date 2019/10/15 11:55
 */
public class G16ValuePassed {
  /**
   * Java中的传参均为值传递
   * 如果是引用类型，那就是传递了地址的拷贝
   * 举个栗子，我有一个去天安门的地址，然后复印了一份给张三
   */
  public static void main(String[] args) {
    String name1 = "老干妈";
    G16User u1 = new G16User(name1);

    System.out.println(u1.name);


    G16User u2 = u1;
    change1(u2);
    System.out.println(u1.name);

    change2(u2);
    System.out.println(u1.name);
  }

  public static void change1(G16User user) {
    user.name = "老干爹";
  }
  public static void change2(G16User user) {
    user = new G16User("腊味饭");
  }
}
class G16User {
  String name;
  public G16User(String name) {
    this.name = name;
  }
}
