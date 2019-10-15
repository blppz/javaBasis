package grammar;

import java.math.BigDecimal;

/**
 * @Deacription 大数运算
 * @Author BarryLee
 * @Date 2019/10/14 14:52
 */
public class G04BigDecimal {
  public static void main(String[] args) {
    BigDecimal bd = BigDecimal.valueOf(1);
    bd = bd.subtract(BigDecimal.valueOf(0.1));
    bd = bd.subtract(BigDecimal.valueOf(0.1));
    bd = bd.subtract(BigDecimal.valueOf(0.1));
    bd = bd.subtract(BigDecimal.valueOf(0.1));
    bd = bd.subtract(BigDecimal.valueOf(0.1));
    System.out.println(bd);

    System.out.println(1-0.1-0.1-0.1-0.1-0.1);
    //0.5
    //0.5000000000000001?

    BigDecimal bd2 =BigDecimal.valueOf(0.5);
    System.out.println(bd.equals(bd2)); // true
  }
}
