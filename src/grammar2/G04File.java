package grammar2;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/20 10:32
 */
public class G04File {
  /**
   * 1.path分割方式
   * 建议使用\
   * 或者是拼接File.pathSeparator
   * 如果是使用/需要写成//，但是这是windows环境适用的，Linux下是\，所以还是使用上面两种方式好，跨平台
   *
   * 2.在工程中，很少说指定什么盘符，都是相对工程路径的
   * 所以需要了解user.dir的获取
   *
   * 3.new File(...)其实就是创建对象，所以它并不关心文件是否存在，而是我们进行关注，没有的话就要进行创建
   *
   * 4.getPath: 如果构建时使用绝对路径，返回的是绝对路径，
   * 如果构造时使用相对路径，返回的时相对路径
   *
   * fileOutputStream(file, true) 可以指定是否追加
   */
  public static void main(String[] args) {
    System.out.println(System.getProperty("user.dir"));
  }
}
