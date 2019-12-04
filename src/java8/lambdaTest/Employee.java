package java8.lambdaTest;

import java.io.Serializable;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/11/28 21:55
 */
public class Employee implements Serializable {
  private String name;
  private Integer age;
  private Double salary;

  @Override
  public String toString() {
    return "Employee{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", salary=" + salary +
        '}';
  }

  public Employee() {
  }

  public Employee(String name, Integer age, Double salary) {
    this.name = name;
    this.age = age;
    this.salary = salary;
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
}
