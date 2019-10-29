package grammar3;

import org.junit.Test;

import java.sql.*;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/29 9:20
 */
public class G09jdbcStatement {

  /**
   * 1.注册驱动
   *     告知JVM使用的是哪一个数据库的驱动
   * 2.获得连接
   *    使用JDBC中的类,完成对MySQL数据库的连接
   * 3.获得语句执行平台
   *   通过连接对象获取对SQL语句的执行者对象
   * 4.执行sql语句
   *   使用执行者对象,向数据库执行SQL语句
   *   获取到数据库的执行后的结果
   * 5.处理结果
   * 6.释放资源  一堆close()
   *
   * execute -- 运行语句，返回是否由结果集
   * executeQuery -- insert，返回ResultSet结果集
   * executeUpdate -- delete, insert, update，返回影响行数
   *
   * statement由比较多的缺陷，一般不会使用
   * 1.SQL注入问题
   * 2.字符串需要进行拼接
   */

  // 测试连接耗时
  // 底层是socket，所以比较耗时
  @Test
  public void test0() throws ClassNotFoundException, SQLException {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/myemployees?characterEncoding=utf8&useSSL=true";
    String username = "root";
    String password = "barry";

    long start = System.currentTimeMillis();
    Class.forName(driver);
    DriverManager.getConnection(url, username, password);
    long end = System.currentTimeMillis();
    System.out.println(end-start);// 本地连接，300毫秒左右
  }

  @Test
  public void test1() throws ClassNotFoundException, SQLException {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/myemployees?characterEncoding=utf8&useSSL=true";
    String username = "root";
    String password = "barry";

    Class.forName(driver);
    Connection connection = DriverManager.getConnection(url, username, password);
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("select * from jobs");

    while(resultSet.next()) {
      String jobId = resultSet.getString(1);
      String jobTitle = resultSet.getString(2);
      int minSalary = resultSet.getInt(3);
      int maxSalary = resultSet.getInt(4);
      System.out.println(jobId +","+ jobTitle +","+ minSalary +","+ maxSalary);
    }

    statement.close();
    connection.close();
  }

  // executeUpdate
  @Test
  public void test2() throws ClassNotFoundException, SQLException {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/myemployees?characterEncoding=utf8&useSSL=true";
    String username = "root";
    String password = "barry";

    Class.forName(driver);
    Connection conn = DriverManager.getConnection(url, username, password);
    String sql = "insert into jobs(job_id, job_title, min_salary, max_salary) values('XX_BAL', 'TEST_TITLE', 8000, 12000)";
    Statement st = conn.createStatement();
    int i = st.executeUpdate(sql);
    System.out.println(i);
  }

  @Test
  public void test3() throws ClassNotFoundException, SQLException {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/myemployees?characterEncoding=utf8&useSSL=true";
    String username = "root";
    String password = "barry";

    Class.forName(driver);
    Connection conn = DriverManager.getConnection(url, username, password);
    String sql = "insert into jobs(job_id, job_title, min_salary, max_salary) values('XX_BAL22', 'TEST_TITLE', 8000, 12000)";
    Statement st = conn.createStatement();
    boolean res = st.execute(sql);
    System.out.println(res);
  }


}
