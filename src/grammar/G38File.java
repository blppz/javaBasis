package grammar;

import java.io.File;
import java.io.IOException;

/**
 * @Deacription File的基本用法
 * @Author BarryLee
 * @Date 2019/10/17 14:31
 */
public class G38File {
  /**
   * 所有文件、IO相关操作都放在E盘test文件夹下
   */
  public static void main(String[] args) throws IOException {
    File f1 = new File("e:/test");
    System.out.println(f1.getName());
    // 在f1下创建一个f11;
    File f11 = new File("e:/test/.f11");
    f11.createNewFile();

    // 当前项目路径
    System.out.println(System.getProperty("user.dir"));

    // 另外一些测试
    System.out.println(f11.exists());
    System.out.println(f11.isFile());
    System.out.println(f11.isDirectory());
    System.out.println(f11.lastModified()); // 返回时间戳
    System.out.println(f11.length());
    System.out.println(f11.getPath());

    System.out.println("===============================");
    // 下面用递归遍历test文件夹
    traverse(new File("e:/test"), 0);
  }

  public static void traverse(File fatherFile, int level) {
    for(int i = 0; i < level; i++) {
      System.out.print("-");
    }
    System.out.println(fatherFile.getName());

    if(fatherFile.isDirectory()) {
      File[] files = fatherFile.listFiles();
      for(int i = 0; i< files.length; i++) {
        traverse(files[i], level+1);
      }
    }
  }
}
