package grammar3;

import org.junit.Test;
import util.JDBCUtil;
import util.Utils;

import java.sql.*;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/29 16:29
 */
public class G12sqlDate {

  /**
   * 根据时间范围进行查询
   * @throws SQLException
   */
  @Test
  public void test() throws SQLException {
    Connection connection = null;
    try {
      connection = JDBCUtil.getConnection("myemployees");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    String sql = "select last_name, hiredate from employees where hiredate>? and hiredate<?";
    PreparedStatement pst = connection.prepareStatement(sql);
    Date date1 = new Date(Utils.strToTimestamp("2015-1-1 12:12:12"));
    Date date2 = new Date(Utils.strToTimestamp("2019-1-1 12:12:12"));
    pst.setObject(1, date1);
    pst.setObject(2, date2);

    ResultSet res = pst.executeQuery();
    while(res.next()) {
      System.out.println(res.getString(1) + "," + res.getDate(2));
    }
    JDBCUtil.close(res, pst,connection);
  }
}
