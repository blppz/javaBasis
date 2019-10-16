package planeGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * @Deacription 工具类
 * @Author BarryLee
 * @Date 2019/10/15 20:42
 */
public class GameUtil {
  private GameUtil() {}

  /**
   * 返回指定路径的图片文件
   * @param path path
   * @return image
   */
  public static Image getImage(String path) {
    BufferedImage bi = null;
    System.out.println(path);
    try {
      URL url = GameUtil.class.getClassLoader().getResource(path);
      bi = ImageIO.read(url);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return bi;
  }
}
