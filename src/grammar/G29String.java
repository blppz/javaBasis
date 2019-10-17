package grammar;

/**
 * @Deacription 字符串
 * @Author BarryLee
 * @Date 2019/10/16 16:21
 */
public class G29String {
  /**
   * 字符串，也即是字符序列，内部是一个char[]
   *
   * 字符串常量解析
   * 例如String s = "123" 这时会在 字符串常量池 中存放一个字符串"123"，s只是指向了它
   * 所以当重新赋值s = "234"时，会创建一个新的字符串在字符串常量池中，原来的"123"并没有改变
   *
   * 上面说到常量池
   * 常量池分为：
   * 1. 全局字符串常量池(String Pool)
   *       全局字符串常量池中存放的内容是在类加载完成后存到String Pool中的，
   *       在每个VM中只有一份，存放的是字符串常量的引用值(在堆中生成字符串对象实例)。
   * 2. class文件常量池(Class Constant Pool)
   *       class常量池是在编译的时候每个class都有的，在编译阶段，
   *       存放的是常量(文本字符串、final常量等)和符号引用。
   * 3. 运行时常量池(Runtime Constant Pool)
   *       运行时常量池是在类加载完成之后，将每个class常量池中的符号引用值转存到运行时常量池中，
   *       也就是说，每个class都有一个运行时常量池，类在解析之后，
   *       将符号引用替换成直接引用，与全局常量池中的引用值保持一致。
   */

  public static void main(String[] args) {
    String s1 = "123";
    String s2 = "123";
    String s3 = new String("123");
    System.out.println(s1 == s2); // true
    System.out.println(s2 == s3); // false
    // 判断字符串相等用equals
    System.out.println(s2.equals(s3)); // true

    System.out.println("-------------");

    String javaFile = "dudu.java";
    System.out.println(javaFile.endsWith(".java"));
    byte[] bs = javaFile.getBytes();
    System.out.println(bs);
    System.out.println(javaFile.charAt(2));
    System.out.println(javaFile.substring(3));
    System.out.println(javaFile.substring(3, 4));// [) -- 左包含右不包含

  }
}
