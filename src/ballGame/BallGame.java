package ballGame;

import javax.swing.*;
import java.awt.*;

/**
 * @Deacription 第一个小游戏
 * @Author BarryLee
 * @Date 2019/10/14 8:55
 */
public class BallGame extends JFrame {

  private Image ball = Toolkit.getDefaultToolkit().getImage("ballGameImgs/ball.png");
  private Image desk = Toolkit.getDefaultToolkit().getImage("ballGameImgs/desk.jpg");

  private double x = 100;
  private double y = 100;

  private boolean right = true;

  // 画窗口的方法
  public void paint(Graphics g) {
    System.out.println("重画窗口了");
    // 先加载桌子
    // 这里有个图片加载
    g.drawImage(desk, 0, 0, null);
    // 桌子边框40，球宽度30
    if(x > 856-40-30) {
      right = false;
    }
    if(x < 40) {
      right = true;
    }

    g.drawImage(ball, (int)x, (int)y, null);

    if(right) {
      x += 10;
    } else {
      x -= 10;
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
        // 40ms重画一次
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    BallGame ballGame = new BallGame();
    ballGame.lunchFrame();
  }
}

