package grammar3;

import org.junit.Before;
import org.junit.Test;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Deacription 事务
 * @Author BarryLee
 * @Date 2019/10/29 11:37
 */
public class G11Transaction {

  /**
   * 事务：一组要么同时执行成功，要么同时执行失败的SQL语句，是数据库操作的一个执行单元
   * 四大特性：原子性、持久性、隔离性、一致性
   */
  private Connection conn;
  @Before
  public void before() {
    try {
      conn = JDBCUtil.getConnection("myemployees");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // 测试回滚
  @Test
  public void test1() {
    try {
      conn.setAutoCommit(false);
      String sql1 = "insert into jobs(job_id, job_title, min_salary, max_salary) values(?,?,?,?)";
      String sql2 = "insert into jobs(job_id, job_title, min_salary, max_salary) values(?,?,?,?,?)";

      // 第一个成功
      PreparedStatement pst1 = conn.prepareStatement(sql1);
      pst1.setString(1, "LAO_BEI1");
      pst1.setString(2, "FOR_TEST");
      pst1.setInt(3, 3000);
      pst1.setInt(4, 5000);

      // 第二个失败
      PreparedStatement pst2 = conn.prepareStatement(sql2);
      pst2.setString(1, "LAO_BEI2");
      pst2.setString(2, "FOR_TEST");
      pst2.setInt(3, 3000);
      pst2.setInt(4, 5000);

      // 执行
      pst1.executeUpdate();
      pst2.executeUpdate();

      conn.commit();
    } catch (SQLException e) {
      e.printStackTrace();
      try {
        if(conn != null) {
          conn.rollback();
        }
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    }
  }
}
