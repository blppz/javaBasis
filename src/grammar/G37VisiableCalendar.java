package grammar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Deacription 可视化日历Demo
 * @Author BarryLee
 * @Date 2019/10/17 11:08
 */
public class G37VisiableCalendar {
  /**
   * 可拓展的方面：
   * 1.时间可输入
   * 2.标识当前第几天
   */
  public static void main(String[] args) throws ParseException {

    // 1.将字符串转换为日历对象
    String dateString = "2019.10.10";
    DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
    Date date = dateFormat.parse(dateString);
    Calendar c = new GregorianCalendar();
    c.setTime(date);

    // 2.保存原来的day
    int day = c.get(Calendar.DAY_OF_MONTH);

    // 3.先将头部打印出来
    System.out.println("日\t一\t二\t三\t四\t五\t六");
    c.set(Calendar.DAY_OF_MONTH, 1);
    // 4.1号不一定就是周日，所以要跳格
    for(int i = 0; i < c.get(Calendar.DAY_OF_WEEK) - 1; i++) {
      System.out.print("  \t");
    }
    // 5.日期
    int len = c.getActualMaximum(Calendar.DATE);
    for(int i = 0; i < len; i++) {
      int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
      if(dayOfMonth < 10) {
        System.out.print(" " + dayOfMonth + "\t");
      } else {
        System.out.print(dayOfMonth + "\t");
      }
      if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
        System.out.println();
      }
      c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 1);
    }
  }
}
