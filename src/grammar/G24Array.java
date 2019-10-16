package grammar;

/**
 * @Deacription 数组
 * @Author BarryLee
 * @Date 2019/10/15 16:57
 */
public class G24Array {
  /**
   * 数组的特征
   * 1.长度确定
   * 2.元素类型相同
   * 3.数组的类型可以是任意的类型，包括基本数据类型和引用数据类型
   * 4.数组本来就是对象
   *
   * 自动赋初值
   *
   * 初始化三种方式
   * 1.静态初始化：创建的时候直接就赋值了
   * 2.默认初始化，就是不手动赋值，让系统赋默认值
   * 3.动态初始化，先不管，然后后面一个个的动态给定值
   */

  public static void main(String[] args) {
    int[] a1 = {1, 2};
    int[] a2 = new int[]{1, 2};

    // forEach遍历，用来遍历，不能用来写入
    for(int a: a2) {
      System.out.println(a);
    }
  }
}
