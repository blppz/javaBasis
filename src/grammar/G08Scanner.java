package grammar;

import java.util.Scanner;

/**
 * @Deacription 输入
 * @Author BarryLee
 * @Date 2019/10/14 20:09
 */
public class G08Scanner {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String line = scanner.nextLine();
    System.out.println(line);

    int born = scanner.nextInt();
    System.out.println((2019-born) * 365);

    // switch 支持的类型
    byte by = 12;
    short sh = 123;
    char b = 'a';
    int a = 1;
    String c = "asdf";
    // 同时，要注意这些有包装类型的，如果放了个包装类型，是OK的，但不是证明switch支持，而是自动拆箱
    switch (c) {

    }
  }
}
