package grammar2;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.EmptyFileFilter;

import java.io.File;
import java.util.Collection;

/**
 * @Deacription apache commons io 的使用
 * @Author BarryLee
 * @Date 2019/10/21 16:19
 */
public class G14CommonsIO_1 {

  /**
   * 原理和自己写的一样的，但人家已经封装好了，在企业，通常不建议自己写轮子，
   * 但是，但是，要学习人家的，多看源码
   */

  public static void main(String[] args) {
    long size = FileUtils.sizeOf(new File("e:/test"));
    System.out.println(size);

    Collection<File> files = FileUtils.listFiles(new File("e:/test"), EmptyFileFilter.NOT_EMPTY, null);
    for(File f: files) {
      System.out.println(f.getName());
    }
  }
}
