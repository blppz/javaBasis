package grammar3;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/28 20:29
 */
public class G09Regex {
  /**
   * 大小写是相反的意思
   * \d 数字  \D 非数字
   * \w 任意字母、数字、下划线
   * \s 空格、制表符、换行符等空白符中任意一个
   * .  任意字符（除了换行符）
   *
   * []  里面的字符是 ’或‘的意思
   *
   * [\s\S]  任意字符，包括换行符
   * [258] 2 或 5 或 8
   * [^258] 258以外，^表示取反
   * [2-8]  表示2到8
   *
   * [] 里面的特殊字符（除了^-）其他都失去了原来的意义
   * [\d.\-+] 表示：数字、点、-、+
   *
   * \d{3}  连续3个数字
   * \d\d{3} 连续4个数字
   * (\d\d){3} 连续6个数字
   *
   * 匹配模式默认为贪婪模式如下
   * \d{3,6}  如果找到三个数字，还会看下一个是否符合，字符越多越好就是贪婪模式
   * \d{3,6}?  加个问好在后面，取消贪婪模式，匹配到三个就是一次
   *
   * ?  零或一，相当于{0,1}
   * +  至少出现一个{1,}
   * *  出现任意次
   *
   * 边界字符：匹配的是位置而不是字符，符合某种条件的字符
   * ^ 匹配开始
   * $ 匹配结束
   * \b 单词
   *
   */

  @Test
  public void test1() {
    // 定义正则
    Pattern pattern = Pattern.compile("\\d{3}[a-z]+");
    // 定义待匹配的字符串
    Matcher matcher = pattern.matcher("123abc");
    // 匹配 - matches()方法匹配的是整一个字符串
    boolean matches = matcher.matches();
    System.out.println(matches);
  }

  @Test
  public void test2() {
    Pattern pattern = Pattern.compile("\\d{3}[a-zA-X]*");
    Matcher matcher = pattern.matcher("123aaC-=-=339hhh");
    // find方法会匹配到多个，相当于有个游标一直往前移动
    System.out.println(matcher.find());
    // 输出找到的内容
    System.out.println(matcher.group());

    System.out.println(matcher.find());
    System.out.println(matcher.group());

    // 最后一个没了，返回false，如果调用matcher.group()将会报错：java.lang.IllegalStateException
    System.out.println(matcher.find());

    // 简写成下面的代码
    //while(matcher.find()) {
    //  System.out.println(matcher.group());
    //}
  }

  /**
   * 替换
   */
  @Test
  public void test3() {
    Pattern pattern = Pattern.compile("[1-8]");
    Matcher matcher = pattern.matcher("aa123**aa345**");
    //String res = matcher.replaceAll("#");
    String res = matcher.replaceAll("\\$"); // 特殊符号要转移
    System.out.println(res);
  }
}
