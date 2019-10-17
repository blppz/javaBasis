package grammar;

/**
 * @Deacription 装箱拆箱
 * @Author BarryLee
 * @Date 2019/10/16 21:02
 */
public class G32Integer {
  public static void main(String[] args) {

    /**
     * 1.
     * 这里要注意的时自动装箱 拆箱 的空指针问题
     * 比如
     * Integer i = null;
     * int i2 = i; // 此时会调用i.intInteger自动拆箱，这就发生空指针异常了
     *
     */

    // 1.自动装箱
    Integer i1 = 3;

    // 2.自动拆箱
    int i2 = i1;

    // 3.手动装箱
    Integer i3 = Integer.valueOf(5);

    // 4.手动拆箱
    Integer i4 = i3.intValue();


    /**
     * 2.
     * 缓存问题
     * 缓存[-128, 127] 之间的数字
     * 出现的情况是比较相等问题
     * 事实上，可以看Integer.valueOf()方法的源码，可以看到-128到127之间是使用缓存好的对象的
     * if (i >= IntegerCache.low && i <= IntegerCache.high)
     *             return IntegerCache.cache[i + (-IntegerCache.low)];
     *         return new Integer(i);
     * 实际上就是初始化时创建了一个Integer[] cache数组
     *
     * 为什么要缓存[-128, 127]呢，网上有人说时享元模式
     * */
    System.out.println("----------------");
    Integer i11 = 3;
    Integer i12 = 3;
    System.out.println(i11 == i12);
    System.out.println(i11.equals(i12));
    Integer i21 = 128;
    Integer i22 = 128;
    System.out.println(i21 == i22);
    System.out.println(i21.equals(i22));
  }
}
