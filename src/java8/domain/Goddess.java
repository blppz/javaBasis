package java8.domain;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/11/30 21:53
 */
public class Goddess {
  private String name;

  public Goddess() {
  }

  public Goddess(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Goddess{" +
        "name='" + name + '\'' +
        '}';
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
