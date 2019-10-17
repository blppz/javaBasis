package grammar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Deacription 日历类
 * @Author BarryLee
 * @Date 2019/10/17 9:53
 */
public class G36Calendar {

  /**
   * Calendar是个抽象类，一般使用子类GregorianCalendar
   */

  public static void main(String[] args) {
    /**
     * 1.获取
     */
    //new GregorianCalendar()什么都不传就是当前
    Calendar calendar = new GregorianCalendar(3100, 10, 25, 8, 20, 30);
    int y = calendar.get(Calendar.YEAR);
    int m = calendar.get(Calendar.MONTH) + 1; // 这是从0开始的
    int d = calendar.get(Calendar.DAY_OF_MONTH);
    System.out.println(y + "," + m + "," + d);

    int week = calendar.get(Calendar.DAY_OF_WEEK);
    // 这里也注意一下，星期几这个参数，老外是从星期天开始算的，星期天为1，星期一为2 ...以此类推
    System.out.println(week);

    /**
     * 2.设置
     */
    Calendar c = new GregorianCalendar();
    c.set(Calendar.YEAR, 3450);
    System.out.println(c.get(Calendar.YEAR));


    /**
     * 时间对象转换为日历对象
     */
    Calendar c2 = new GregorianCalendar();
    c2.setTime(new Date());
    System.out.println(c2);

    // 根据时间戳也可以转换为时间对象
    System.out.println(c2.getTimeInMillis());
  }
}
