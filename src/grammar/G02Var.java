package grammar;

import java.util.HashMap;
import java.util.Map;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/8/18 22:36
 */
public class G02Var {
    /*
    * 常量和变量
    *
    * 变量
    *   byte 8位，-128 ~ 127
    *   short 16位
    *   int  32位
    *   long  64位
    *   float  32位
    *   double  64位
    *   boolean  1位
    *   char  单一的16位Unicode字符
    * */

    public static void main(String[] args) {
        // 用这种方式就可以看到字节 以及 数值大小的范围了
        System.out.println(Byte.SIZE);
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);


        long a = 4;
        System.out.println(a);
        // 这个b超过了int类型范围，所以要加个L，但是一般long类型，都加上
        long b = 9999999999999L;
        System.out.println(b);

        // 2.自动类型转换
        // byte ->short, char->int->long->float->double
    }







}
