package planeGame;

import java.awt.*;

/**
 * @Deacription 炮弹
 * @Author BarryLee
 * @Date 2019/10/16 9:58
 */
public class Sheel extends GameObject{

  double degree;

  public Sheel() {
    x = 200;
    y = 200;
    width = 10;
    height = 10;
    speed = 3;

    degree = Math.PI*2 * Math.random();
  }

  public void drawSelf(Graphics g) {
    Color c = g.getColor();
    g.setColor(Color.yellow);
    g.fillOval((int)x, (int)y, width, height);

    // 炮弹沿着任意角度飞
    x += speed * Math.cos(degree);
    y += speed * Math.sin(degree);

    // 碰到墙之后角度反转
    if(x < 0 || x > Constant.GAME_WIDTH - width) {
      degree = Math.PI - degree;
    }
    if(y < 30 || y > Constant.GAME_HEIGHT - height) {
      degree = -degree;
    }

    g.setColor(c);
  }

}
