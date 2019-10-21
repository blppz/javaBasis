package grammar2;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/20 16:50
 */
public class G08Decorator01 {
  /**
   * 准备学IO的装饰类，来几个装饰者模式Demo
   *
   */
  public static void main(String[] args) {
    G08Person person = new G08Person();
    person.say();

    G08Amplifire am = new G08Amplifire(person);
    am.say();
  }
}

/**
 * 接口
 */
interface G08Father {
  int voice = 10;
  void say();
}

/**
 * 人
 */
class G08Person implements G08Father{
  public G08Person() {
  }
  public void say() {
    System.out.println("人的声音是" + voice + "分贝");
  }
}

/**
 * 扩音器
 */
class G08Amplifire implements G08Father{
  private G08Father father;

  public G08Amplifire(G08Father father) {
    this.father = father;
  }

  @Override
  public void say() {
    System.out.println("人的声音经过扩大后是" + (father.voice * 10) + "分贝");
  }
}
