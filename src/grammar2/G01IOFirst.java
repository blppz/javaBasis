package grammar2;

/**
 * @Deacription IO
 * @Author BarryLee
 * @Date 2019/10/19 22:17
 */
public class G01IOFirst {
  /**
   * IO开篇
   * IO中最为重要的五大类、三大接口
   *
   * File 文件类
   * InputStream 字节输入流
   * OutputStream 字节输出流
   * Reader 字符输入流
   * Writer 字符输出流
   *
   * Closeable 关闭流接口
   * Flushable 刷新流接口
   * Serializable 序列化接口
   *
   * 输入输出都是以程序为中心
   *
   * 怎么阅读API文档
   * 1.关注构造，自己构造还是调用方法内部构造、不能构造（比如工具类）
   * 2.关注方法，方法名称是什么，什么用途、权限是什么、需要传入什么参数、返回什么值
   *
   * close()关流，其实就是通知关流，而不是真的我们程序有权限关流，因为我们程序和File之间其实还有一层OS
   */
}
