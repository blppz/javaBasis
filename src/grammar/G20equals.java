package grammar;

import java.util.Objects;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/15 15:37
 */
public class G20equals {

  /**
   * 重写equals
   */

  private int id;
  private String name;
  private int age;

  public static void main(String[] args) {
    G20equals e1 = new G20equals();
    e1.id = 1;
    e1.name = "希希";
    e1.age = 20;

    G20equals e2 = new G20equals();
    e2.id = 1;
    e2.name = "大叔";
    e2.age = 23;

    System.out.println(e1 == e2);
    System.out.println(e1.equals(e2));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    G20equals g20equals = (G20equals) o;

    return id == g20equals.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, age);
  }

}
