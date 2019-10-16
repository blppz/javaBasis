package planeGame;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

/**
 * @Deacription 飞机游戏主窗口
 * @Author BarryLee
 * @Date 2019/10/15 20:13
 */
public class MyGameFrame extends Frame {

  // 加载两张图
  Image bg = GameUtil.getImage("planeGameImages/bg.jpg");
  Image planeImage = GameUtil.getImage("planeGameImages/plane.png");

  Plane plane = new Plane(planeImage, 250, 250);
  Sheel[] sheels = new Sheel[50];

  Explode bao = null;
  Date startTime = new Date();
  Date endTime = null;
  int time;

  /**
   * 初始化窗口
   */
  public void launchFrame() {
    this.setTitle("打飞机游戏");
    this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
    this.setLocation(500, 200);
    //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //上面一句也可以写成监听
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    this.setVisible(true);

    new PaintThread().start();

    this.addKeyListener(new KeyMonitor());
    for(int i = 0; i < sheels.length; i++) {
      sheels[i] = new Sheel();
    }
  }

  @Override
  public void paint(Graphics g) {
    Color color = g.getColor();
    g.drawImage(bg, 0, 0, null);
    // 画飞机
    plane.drawSelf(g);

    // 画炮弹
    for(int i = 0; i < sheels.length; i++) {
      sheels[i].drawSelf(g);

      // 判断飞机与炮弹是否相碰
      if(sheels[i].getRectangle().intersects(plane.getRectangle())) {
        plane.live = false;

        if(bao == null) {
           bao = new Explode(plane.x, plane.y);
           endTime = new Date();
           time = (int)((endTime.getTime() - startTime.getTime()) / 1000);
        }

        bao.draw(g);
      }
      if(!plane.live) {
        g.setColor(Color.red);
        g.setFont(new Font("楷体", Font.BOLD, 26));
        g.drawString(time + "秒", 250, 250);
      }
    }

    g.setColor(color);
  }

  // 重画窗口线程
  class PaintThread extends Thread {
    @Override
    public void run() {
      while(true) {
        repaint();

        try {
          Thread.sleep(40);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  /**
   * ctrl + o快速重写父类方法
   */
  class KeyMonitor extends KeyAdapter {

    // 按下
    @Override
    public void keyPressed(KeyEvent e) {
      plane.addDirection(e);
    }

    // 抬起
    @Override
    public void keyReleased(KeyEvent e) {
      plane.minuDirection(e);
    }
  }

  private Image offScreenImage = null;
  public void update(Graphics g) {
    if(offScreenImage == null) {
      //这是游戏窗口的宽度和高度
      offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
    }

    Graphics gOff = offScreenImage.getGraphics();
    paint(gOff);
    g.drawImage(offScreenImage, 0, 0, null);
  }

  public static void main(String[] args) {
    MyGameFrame frame = new MyGameFrame();
    frame.launchFrame();
  }
}
