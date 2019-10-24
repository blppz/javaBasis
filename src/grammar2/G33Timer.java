package grammar2;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/23 19:30
 */
public class G33Timer {
  /**
   * 定时执行任务
   * TimerTask可以由计时器进行一次性或重复执行的任务
   *
   * 当任务复杂的时候可以考虑使用：QUARTZ框架  quartz
   * 它已经集成到spring中了
   */
  public static void main(String[] args) {
    Timer timer = new Timer();
    timer.schedule(new MyTimer(), 1000, 1000);
    try {
      Thread.sleep(10*1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    timer.cancel();
  }
  static class MyTimer extends TimerTask {
    @Override
    public void run() {
      System.out.println("任务执行");
    }
  }
}
