package planeGame;

import java.awt.*;

/**
 * @Deacription 游戏物体的父类
 * @Author BarryLee
 * @Date 2019/10/16 9:10
 */
public class GameObject {
  Image image;
  double x, y;
  int speed;
  int width, height;

  public void drawSelf(Graphics g) {
    g.drawImage(image, (int)x, (int)y, null);
  }

  public GameObject() {
  }

  public GameObject(Image image, double x, double y, int speed, int width, int height) {
    this.image = image;
    this.x = x;
    this.y = y;
    this.speed = speed;
    this.width = width;
    this.height = height;
  }

  public GameObject(Image image, double x, double y) {
    this.image = image;
    this.x = x;
    this.y = y;
  }

  /**
   * 返回物体所在的矩形，方便后续操作，比如判断碰撞
   * @return
   */
  public Rectangle getRectangle() {
    return new Rectangle((int)x, (int)y, width, height);
  }
}
