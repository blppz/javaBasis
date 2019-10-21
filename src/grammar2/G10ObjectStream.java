package grammar2;

import java.io.*;
import java.util.Objects;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/20 20:34
 */
public class G10ObjectStream {
  /**
   * 测试对象流
   * ObjectInputStream, ObjectOutputStream
   * 方法：readObject, writeObject
   * 注意：实现了Serializable接口的类才可以序列化
   * 区分序列化和反序列化
   * transient修饰的属性不可序列化
   *
   * Demo: 将对象写出到文件，然后读进来
   */
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("e:/test/testObjectStream.bl")));

    out.writeObject(new G10Person(1001, "老干妈", "123123", 9090.99));
    out.writeObject(new G10Person(1002, "小姨妈", "321321", 5090.99));

    out.flush();

    // new ObjectInputStream放在out.flush()之后，否则出现EOF异常
    // 见博客: https://blog.csdn.net/qq_38238041/article/details/102653867
    ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("e:/test/testObjectStream.bl")));

    G10Person person1 = (G10Person) in.readObject();
    G10Person person2 = (G10Person) in.readObject();
    System.out.println(person1);
    System.out.println(person2);

    out.close();
    in.close();
  }
}

class G10Person implements Serializable {
  private Integer id;
  private String name;
  private transient String password;
  private Double salary;

  public G10Person() {
  }

  public G10Person(Integer id, String name, String password, Double salary) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.salary = salary;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "G10Person{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", password='" + password + '\'' +
        ", salary=" + salary +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    G10Person g10Person = (G10Person) o;
    return Objects.equals(id, g10Person.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}