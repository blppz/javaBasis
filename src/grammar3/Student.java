package grammar3;

import java.util.Objects;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/28 15:27
 */
class Student {
  private int age;
  private String name;

  public Student() {
  }

  public Student(int age, String name) {
    this.age = age;
    this.name = name;
  }

  public void sayHi() {
    System.out.println("hi");
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return age == student.age &&
        name.equals(student.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(age, name);
  }

  @Override
  public String toString() {
    return "Student{" +
        "age=" + age +
        ", name='" + name + '\'' +
        '}';
  }
}
interface A{
  void a(int a);
}
interface B{
  void a();
}
class CC implements A, B{
  @Override
  public void a(int a) {

  }

  @Override
  public void a() {

  }
}

interface C extends A, B{

}