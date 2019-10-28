package grammar3;

import org.junit.Before;
import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.List;

/**
 * @Deacription Rhino是一种使用Java编写的JavaScript开源实现，原先由Mozilla开发，后来继承到JDK6中
 *
 * 想要了解更多关于JS-Java，可以了解Rhino
 *
 * 但是呢！JDK8中 Nashorn 取代 Rhino  https://www.infoq.cn/article/nashorn
 * Nashorn文档：https://docs.oracle.com/javase/7/docs/technotes/guides/scripting/programmer_guide/#top
 * 可见，使用方法是一毛一样的，因为都是同样的接口，只是底层修改了
 *
 * @Author BarryLee
 * @Date 2019/10/28 10:40
 */
public class G07ScriptEngine {

  private ScriptEngineManager manager;
  private ScriptEngine jsEngine;

  /**
   * 初始化
   */
  @Before
  public void before() {
    manager = new ScriptEngineManager();
    jsEngine = manager.getEngineByName("js");
  }

  /**
   * 脚本语言执行
   */
  @Test
  public void test1() throws ScriptException {
    // 存放一个msg到jsEngine的上下文，Java以及脚本都可以获取到这个msg
    jsEngine.put("msg", "barry is a good man");

    String str = "var user={name: 'barry', age: 24};";
    // 别人写print报错，要写成println，为什么我的相反？
    str += "print(user.name);";

    // 使用jsEngine执行字符串
    jsEngine.eval(str);

    // 获取jsEngine里面的参数输出
    System.out.println(jsEngine.get("msg"));
    // 使用jsEngine修改msg，然后再打印
    jsEngine.eval("msg='barry is your boy friend'");
    System.out.println(jsEngine.get("msg"));
  }

  /**
   * 执行脚本函数
   */
  @Test
  public void test2() throws ScriptException, NoSuchMethodException {
    // 定义函数
    jsEngine.eval("function add(a, b) {return a + b;}");

    // 获取调用接口
    Invocable jsInvoke = (Invocable) jsEngine;
    // 执行
    Object res = jsInvoke.invokeFunction("add", 1, 2);
    System.out.println(res);
  }

  /**
   * js使用java包
   */
  @Test
  public void test3() throws ScriptException {
    // 注意，这里的java.util.Arrays.asList是jkd1.8语法，
    // 之前的6是先进行导入：importPackage java.util;
    // 定义一个list，他会自动放到jsEngine
    jsEngine.eval("var list=java.util.Arrays.asList(['逸川同学','逸川先生','有钱人'])");
    // 然后可以将list拿出来
    List<String> list = (List<String>) jsEngine.get("list");
    for(String s: list) {
      System.out.println(s);
    }
  }

  /**
   * 执行JS文件
   */
  @Test
  public void test4() throws FileNotFoundException, ScriptException {
    URL url = G07ScriptEngine.class.getClassLoader().getResource("testJsEngine.js");
    jsEngine.eval(new FileReader(url.getPath()));
  }

}