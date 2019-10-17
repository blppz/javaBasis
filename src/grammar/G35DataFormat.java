package grammar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/17 9:33
 */
public class G35DataFormat {

  /**
   * DataFormat是一个抽象类，平常用的是SimpleDataFormat
   * 可以进行字符串可日期类之间的转换
   */

  public static void main(String[] args) {
    /**
     * 1.日期对象转字符串
     */
    DateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
    String now = format.format(new Date());
    System.out.println(now);

    /**
     * 2.字符串转对象
     */
    DateFormat format1 = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
    String dataString = "1970年01月01日 0时0分0秒";
    try {
      System.out.println(format1.parse(dataString));
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

}
