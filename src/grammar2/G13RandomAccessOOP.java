package grammar2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Deacription 面向对象思想封装前一个split方法
 * 失败作品
 * @Author BarryLee
 * @Date 2019/10/21 10:58
 */
public class G13RandomAccessOOP {
  public static void main(String[] args) throws IOException {
    MyRandomAccess ac = new MyRandomAccess(new File("E:/test/01.jpg"), 1024*100);
    //ac.split();
    ac.join(new File("e:/test/01.jpg_copy"));
  }
}

class MyRandomAccess {
  private File src;
  private int oneBlockSize;
  private RandomAccessFile inFile;

  public MyRandomAccess() {}
  public MyRandomAccess(File src, int oneBlockSize) throws IOException {
    this.src = src;
    this.oneBlockSize = oneBlockSize;
    inFile = new RandomAccessFile(src, "r");
  }

  public void split() throws IOException {
    File dir = new File(src.getParent() +"/" + src.getName() + "_copy/");
    dir.mkdirs();

    long beginPos;
    int blockNum = (int) Math.ceil(inFile.length()*1.0 / oneBlockSize);
    long rafLength = inFile.length();
    long actualSize;

    for(int i = 0; i < blockNum; i++) {
      beginPos = i * oneBlockSize;
      if(i == blockNum - 1) {
        actualSize = rafLength;
      } else {
        actualSize = oneBlockSize;
        rafLength -= oneBlockSize;
      }
      //System.out.println(i + "--" + beginPos + "--" + actualSize);
      File file = new File(dir, i + ".bl");
      file.createNewFile();
      copy(inFile, file, (int)beginPos, (int)actualSize);
    }

    inFile.close();
  }

  private void copy(RandomAccessFile inFile, File file, int beginPos, int needSize) throws IOException {
    RandomAccessFile destFile = new RandomAccessFile(file, "rw");
    int len;
    byte[] bs = new byte[1024];
    inFile.seek(beginPos);
    while((len = inFile.read(bs)) != -1) {
      if(needSize > len) {
        //System.out.println(new String(bs, 0, len));
        destFile.write(bs);
        needSize -= len;
      } else {
        destFile.write(bs);
        //System.out.println(new String(bs, 0, needSize));
        needSize = 0;
      }
    }
    destFile.close();
  }

  /**
   * 拼接
   */
  public void join(File src) throws IOException {
    String path = src.getPath();
    String fileName = src.getName().substring(0, src.getName().length()-5);
    //RandomAccessFile outFile = new RandomAccessFile(path + fileName, "rw");
    File outFile = new File(path + "/" + fileName);
    File[] files = src.listFiles();
    RandomAccessFile inFile;
    for(int i = 0; i < files.length; i++) {
      inFile = new RandomAccessFile(path + "/" + i + ".bl", "r");
      copy(inFile, outFile, 0, (int) inFile.length());
    }
  }
}