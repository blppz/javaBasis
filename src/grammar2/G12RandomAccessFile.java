package grammar2;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Deacription 随机读取和写入流
 * @Author BarryLee
 * @Date 2019/10/21 9:20
 */
public class G12RandomAccessFile {

  /**
   * 测试从指定位置开始，读到结尾
   */
  @Test
  public void test1() throws IOException {
    RandomAccessFile raFile = new RandomAccessFile("e:/test/testRandom.txt", "r");
    int len;
    byte[] bs = new byte[1024];
    raFile.seek(3);
    while((len = raFile.read(bs)) != -1) {
      System.out.println(new String(bs, 0, len));
    }

    raFile.close();
  }

  /**
   * 从指定位置开始读，数组是1024，然后要读取1026个字节
   */
  @Test
  public void test2() throws IOException {
    split(3, 1026);
  }

  public void split(int beginPos, int needSize) throws IOException {
    RandomAccessFile raFile = new RandomAccessFile("e:/test/testRandom.txt", "r");
    int len;
    byte[] bs = new byte[1024];
    raFile.seek(beginPos);
    //int needSize = 1026; // 需要读取1026字节
    while((len = raFile.read(bs)) != -1) {
      if(needSize > len) {
        System.out.println(new String(bs, 0, len));
        needSize -= len;
      } else {
        System.out.println(new String(bs, 0, needSize));
        needSize = 0;
      }
    }
    raFile.close();
  }

  /**
   * 分块思想，将文件分成多块
   */
  @Test
  public void test3() throws IOException {
    RandomAccessFile raFile = new RandomAccessFile("e:/test/testRandom.txt", "r");
    int oneBlockSize = 1024;
    byte[] bs = new byte[oneBlockSize];
    long beginPos = 0;
    int blockNum = (int) Math.ceil(raFile.length()*1.0 / oneBlockSize);
    long rafLength = raFile.length();
    long actualSize;

    for(int i = 0; i < blockNum; i++) {
      beginPos = i * oneBlockSize;
      if(i == blockNum - 1) {
        actualSize = rafLength;
      } else {
        actualSize = oneBlockSize;
        rafLength -= oneBlockSize;
      }
      System.out.println(i + "--" + beginPos + "--" + actualSize);
      split((int)beginPos, (int)actualSize);
    }

    raFile.close();
  }

}
