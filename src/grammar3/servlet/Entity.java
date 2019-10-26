package grammar3.servlet;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/26 14:16
 */
public class Entity {
  private String name;
  private String clazz;
  public Entity() {};

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getClazz() {
    return clazz;
  }

  public void setClazz(String clazz) {
    this.clazz = clazz;
  }

  @Override
  public String toString() {
    return "Entity{" +
        "name='" + name + '\'' +
        ", clazz='" + clazz + '\'' +
        '}';
  }
}
