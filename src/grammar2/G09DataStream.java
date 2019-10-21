package grammar2;

import java.io.*;

/**
 * @Deacription 数据流：DataInputStream、DataOutputStream，是包装流的一种
 * 与BufferedInputStream同级是FilterInputStream的儿子
 * @Author BarryLee
 * @Date 2019/10/20 19:59
 */
public class G09DataStream {
  public static void main(String[] args) throws IOException {
    // 包装流DataInputStream, DataOutputStream的使用
    // 将数据写出到ByteArrayOutputStream, 然后再拿进来程序
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    DataOutputStream out = new DataOutputStream(baos);
    // ----------------------

    out.writeBoolean(false);
    out.writeInt(77);
    out.writeChars("老干妈");
    out.writeDouble(1.23);
    out.flush();

    // ----------------------
    byte[] bytes = baos.toByteArray();
    DataInputStream in = new DataInputStream(new ByteArrayInputStream(bytes));

    System.out.println(in.readBoolean());
    System.out.println(in.readInt());
    System.out.println(in.readChar());
    System.out.println(in.readDouble());

    out.close();
    in.close();
  }
}
