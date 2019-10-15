package ballGame;

import javax.swing.*;
import java.awt.*;

/**
 * @Deacription 第二个小游戏
 * @Author BarryLee
 * @Date 2019/10/14 8:55
 */
public class BallGame2 extends JFrame {

  private Image ball = Toolkit.getDefaultToolkit().getImage("ballGameImgs/ball.png");
  private Image desk = Toolkit.getDefaultToolkit().getImage("ballGameImgs/desk.jpg");

  private double x = 100;
  private double y = 100;

  private double degree = 3.14/3;

  // 画窗口的方法
  public void paint(Graphics g) {
    System.out.println("重画窗口了");
    // 先加载桌子
    // 这里有个图片懒加载
    g.drawImage(desk, 0, 0, null);
    g.drawImage(ball, (int)x, (int)y, null);

    x = x + 10 * Math.cos(degree);
    y = y + 10 * Math.sin(degree);

    // 窗口菜单栏40px
    if(y > 500 - 80 || y < 80) {
      degree = -degree;
    }

    if(x > 856 - 70 || x < 40) {
      degree = 3.14 - degree;
    }
  }

  // 窗口加载
  private void lunchFrame() {
    // 程序会先执行加载窗口，然后才是paint方法
    // 所以这里相当于初始化
    setSize(856, 500);
    setLocation(100, 200);
    setVisible(true);

    // 重画窗口
    while(true) {
      repaint();
      try {
        // 20ms重画一次
        Thread.sleep(20);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    BallGame2 ballGame = new BallGame2();
    ballGame.lunchFrame();
  }
}

