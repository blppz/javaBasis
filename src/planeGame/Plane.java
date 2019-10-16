package planeGame;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @Deacription 飞机
 * @Author BarryLee
 * @Date 2019/10/16 9:16
 */
public class Plane extends GameObject{

  boolean left, right, up, down;
  boolean live = true;

  public void drawSelf(Graphics g) {
    if(!live) {
      return;
    }

    g.drawImage(image, (int)x, (int)y, null);

    if(left) {
      x -= speed;
    }
    if(right) {
      x += speed;
    }
    if(up) {
      y -= speed;
    }
    if(down) {
      y += speed;
    }
  }

  public Plane(Image image, double x, double y) {
    super(image, x, y);
    this.speed = 4;
    this.width = image.getWidth(null);
    this.height = image.getHeight(null);
  }

  /**
   * 按下方向键，增加相应的方向
   * @param e keyEvent
   */
  public void addDirection(KeyEvent e) {
    switch (e.getKeyCode()) {
      case KeyEvent.VK_LEFT:
        left = true;
        break;
      case KeyEvent.VK_RIGHT:
        right = true;
        break;
      case KeyEvent.VK_UP:
        up = true;
        break;
      case KeyEvent.VK_DOWN:
        down = true;
        break;
    }
  }


  /**
   * 按下方向键，取消相应的方向
   * @param e keyEvent
   */
  public void minuDirection(KeyEvent e) {
    switch (e.getKeyCode()) {
      case KeyEvent.VK_LEFT:
        left = false;
        break;
      case KeyEvent.VK_RIGHT:
        right = false;
        break;
      case KeyEvent.VK_UP:
        up = false;
        break;
      case KeyEvent.VK_DOWN:
        down = false;
        break;
    }
  }
}
