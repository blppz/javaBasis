package java8.domain;

import java.io.Serializable;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/11/30 14:58
 */
public class Employee implements Serializable {
  private static final long serialVersionUID = -8339596516207301902L;

  private Integer id;
  private String name;
  private Integer age;
  private Double salary;

  public Employee() {
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", age=" + age +
        ", salary=" + salary +
        '}';
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

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public Employee(Integer id, String name, Integer age, Double salary) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.salary = salary;
  }
}
