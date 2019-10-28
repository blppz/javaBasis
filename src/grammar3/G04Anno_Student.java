package grammar3;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/27 22:10
 */

@G04Anno_Table("table_student")
public class G04Anno_Student {
  @G04Anno_Field(name="name", type="varchar", length=10)
  private String name;
  @G04Anno_Field(name="age", type="int", length=3)
  private int age;
}
