package grammar3;

import org.junit.Test;
import util.JDBCUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/29 17:03
 */
public class G13ClobBlob {
  /**
   * CLOB: Character Large Object
   * BLOB: Binary Large Object
   *
   * 都是大对象，一个是存放文本数据，一个是存放字节数据
   * 通常以流的方式进行处理
   * 但是值得注意的是，大文件在实际项目中通常存放在文件服务中，而不是数据库
   *
   * tinytext 2^8 - 1
   * text 2^16 - 1
   * mediumtext 2^24 - 1
   * longtext 2^32 - 1 4G
   *
   * tinyblob
   * blob
   * mediumtext
   * longtext
   *
   * 用法:
   * pst.setClog(n, reader)
   * Clog c = res.getClog(xx);c.getCharacterStream();
   *
   */

  @Test
  public void test1() throws SQLException, FileNotFoundException {
    Connection connection = null;
    try {
      connection = JDBCUtil.getConnection("girls");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    // 插入text
    String sql = "insert into test(clob) values(?)";
    PreparedStatement pst = connection.prepareStatement(sql);
    pst.setClob(1, new BufferedReader(new FileReader("e:/test/TestCompiler.java")));
    int i = pst.executeUpdate();
    System.out.println(i);
    JDBCUtil.close(pst, connection);
  }
  @Test
  public void test2() throws SQLException, IOException, ClassNotFoundException {
    Connection connection = JDBCUtil.getConnection("girls");

    String sql = "select * from test";
    PreparedStatement pst = connection.prepareStatement(sql);
    ResultSet res = pst.executeQuery();
    while(res.next()) {
      int id = res.getInt("id");
      Clob clob = res.getClob("clob");
      System.out.println(id);
      BufferedReader reader = new BufferedReader(clob.getCharacterStream());
      String line;
      while((line=reader.readLine())!=null) {
        System.out.println(line);
      }
      System.out.println("-------------");
    }
    JDBCUtil.close(res, pst, connection);
  }
}
