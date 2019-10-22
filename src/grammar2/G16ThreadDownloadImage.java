package grammar2;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @Deacription 多线程下载图片
 * @Author BarryLee
 * @Date 2019/10/21 20:12
 */
public class G16ThreadDownloadImage {

  /**
   * 推荐使用Runnable，虽然实现略微比继承Thread类麻烦
   * 但是这样可以避免单继承的局限性
   */

  public static void main(String[] args) {
    String url1 = "https://img.ivsky.com/img/tupian/pre/201903/26/shuying_sucai-001.jpg";
    String url2 = "https://img.ivsky.com/img/tupian/pre/201012/29/mutou_qiangbi-003.jpg";
    String url3 = "https://img.ivsky.com/img/tupian/pre/201812/25/budalagong-001.jpg";

    G16Runnable r1 = new G16Runnable(url1, "shuying.jpg");
    G16Runnable r2 = new G16Runnable(url2, "shuye.jpg");
    G16Runnable r3 = new G16Runnable(url3, "buda.jpg");

    new Thread(r1).start();
    new Thread(r2).start();
    new Thread(r3).start();
  }
}

class G16Runnable implements Runnable {
  private String url;
  private String name;
  public G16Runnable(String url, String name) {
    this.url = url;
    this.name = name;
  }

  @Override
  public void run() {
    try {
      FileUtils.copyURLToFile(new URL(url), new File("e:/test/testCopyUrlFile/" + name));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}