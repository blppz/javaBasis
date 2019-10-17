package grammar;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Deacription try catch demo
 * @Author BarryLee
 * @Date 2019/10/17 18:55
 */
public class G41tryCatch {
  public static void main(String[] args) {
    FileReader reader = null;
    try {
      reader = new FileReader("F:/e.gg");
      System.out.println("here");
      int res = reader.read();
      System.out.println(res);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally{
      System.out.println("finally");
      try {
        if(reader != null) {
          reader.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
