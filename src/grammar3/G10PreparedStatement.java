package grammar3;

import org.junit.Before;
import org.junit.Test;
import util.JDBCUtil;

import java.sql.*;

/**
 * @Deacription
 * @Author BarryLee
 * @Date 2019/10/29 10:48
 */
public class G10PreparedStatement {

  /**
   * PreparedStatement继承自Statement接口，所以用法上是大同小异的
   * 由预处理，相对高效
   * 不用拼接字符串，可以防止注入
   *
   * 批处理用法：
   * connection.setAutoCommit(false) // 设置手动提交
   * pst.addBatch(); // 添加批处理语句
   * pst.executeBatch() // 执行批处理
   * 要注意：大批量批处理时建议使用Statement，
   * 因为PreparedStatement预编译空间有限，可能出异常
   */

  private Connection connection;
  private PreparedStatement pst;
  private ResultSet res;

  @Before
  public void before() throws ClassNotFoundException, SQLException {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/myemployees?characterEncoding=utf8&useSSL=true";
    String username = "root";
    String password = "barry";
    Class.forName(driver);
    connection = DriverManager.getConnection(url, username, password);
  }

  @Test
  public void test1() throws SQLException {
    String sql = "select * from jobs";
    pst = connection.prepareStatement(sql);
    res = pst.executeQuery();
    while(res.next()) {
      System.out.print(res.getString(1) + ",");
      System.out.print(res.getString(2) + ",");
      System.out.print(res.getInt(3) + ",");
      System.out.println(res.getInt(4));
    }
    JDBCUtil.close(res, pst, connection);
  }

  @Test
  public void test2() throws SQLException {
    String sql = "insert into jobs(job_id, job_title, min_salary, max_salary) values(?,?,?,?)";
    pst = connection.prepareStatement(sql);
    pst.setString(1, "LAO_GAN");
    pst.setString(2, "FOR_TEST");
    pst.setInt(3, 3000);
    pst.setInt(4, 5000);
    int i = pst.executeUpdate();
    System.out.println(i);
    JDBCUtil.close(pst, connection);
  }

}
