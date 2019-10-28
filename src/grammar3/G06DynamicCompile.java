package grammar3;

import org.junit.Test;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/28 9:20
 */
public class G06DynamicCompile {
  /**
   * 动态编译
   * 应用场景：浏览器端写Java代码，上传到服务器端编译运行、服务器动态加载某些类文件进行编译
   * 但是这种情况值得注意的是，因为代码是在服务器执行的，所以要做安全检测
   * 比如人家把你的服务其文件给删除了就大锅了
   *
   * 相关类：JavaCompiler、ToolProvider
   */

  /**
   * 编译一个Java文件
   */
  @Test
  public void test1() {
    /**
     * 如果是一个String
     * 例如：
     * String s =
     *  "public class TestCompiler{public static void main(String[]args){...}}"
     * 可以先存放到文件
     */
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    int res = compiler.run(null, null, null, "e:/test/testCompiler.java");
    System.out.println(res==0 ? "编译成功" : "编译失败");
  }

  /**
   * 执行一个JavaC文件
   * 方法1：通过Runtime.getRuntime
   */
  @Test
  public void test2() throws IOException {
    Runtime r = Runtime.getRuntime();
    // cp classPath的意思
    Process exec = r.exec("java -cp c:/test TestCompiler");
    BufferedReader reader = new BufferedReader(new InputStreamReader(exec.getInputStream()));

    String str;
    while((str=reader.readLine()) != null) {
      System.out.println(str);
    }
  }

  /**
   * 执行一个JavaC文件
   * 方法1：反射，ClassLoader
   */
  @Test
  public void test3() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    URL[] urls = new URL[] {new URL("file:/e:/test/")};
    URLClassLoader loader = new URLClassLoader(urls);
    Class<?> clazz = loader.loadClass("TestCompiler");
    Method main = clazz.getDeclaredMethod("main", String[].class);
    main.invoke(null, (Object)new String[]{});
  }

}
