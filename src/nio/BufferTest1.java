package nio;

import org.junit.Test;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/12/2 23:04
 */
public class BufferTest1 {
  /**
   * mark
   * position
   * limit
   * capacity
   */

  @Test
  public void test1() {
    // 分配非直接缓冲区
    ByteBuffer buffer = ByteBuffer.allocate(1024);
    // 判断是否为直接缓冲区
    System.out.println(buffer.isDirect());
    print(buffer);

    // 往缓冲区存放数据
    buffer.put("abcd".getBytes());
    print(buffer);

    // 修改模式为读取
    buffer.flip();
    print(buffer);

    // 读取两个字节
    byte[] dst = new byte[buffer.limit()];
    buffer.get(dst,0,2);
    System.out.println(new String(dst));
    print(buffer);

    // mark以下在2的位置,reset()的时候，position回到这个回值
    buffer.mark();

    // 然后再读取2-4位置的数据，position移动到4,limit也等于4
    dst = new byte[buffer.limit()];
    buffer.get(dst, 2, 2);
    System.out.println(new String(dst));
    print(buffer);

    // reset以下，position回到mark位置
    buffer.reset();
    print(buffer);

    // clear() 其实是假装清除了数据，也就是数据还在，只是那四个参数都回到了最初设定的位置
    buffer.clear();
    print(buffer);
    try {
      buffer.reset();
      print(buffer);
    }catch (InvalidMarkException e) {
      //e.printStackTrace();
      System.out.println("没有mark呀 .. ");
    }

  }
  @Test
  public void test2() {
    ByteBuffer buffer = ByteBuffer.allocate(1024);
    buffer.put("xiaojiejie".getBytes());
    buffer.flip();
    print(buffer);
    buffer.get();
    print(buffer);
    // limit -> position设置为0，而limit不变
    // 应用场景：
    buffer.rewind();
    print(buffer);

  }
  public void print(Buffer buffer) {
    //System.out.println("mark = " + buffer.mark()); // 这样调用输出直接每次都mark了。。
    System.out.println("position = " + buffer.position());
    System.out.println("limit = " + buffer.limit());
    System.out.println("capacity = " + buffer.capacity());
    System.out.println("===============");
  }
}
