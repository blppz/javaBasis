package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/29 11:55
 */
public class JDBCUtil {
  private JDBCUtil() {}
  private static Properties prop;
  private static String driver;
  private static String url1;
  private static String url2;
  private static String username;
  private static String password;

  static {
    prop = new Properties();
    InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("mysql.properties");
    try {
      prop.load(in);
      driver = prop.getProperty("driver");
      url1 = prop.getProperty("url1");
      url2 = prop.getProperty("url2");
      username = prop.getProperty("username");
      password = prop.getProperty("password");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * connection
   * @return
   */
  public static Connection getConnection(String dataBase) throws ClassNotFoundException, SQLException {
    String url = url1 + dataBase + url2;
    Class.forName(driver);
    return DriverManager.getConnection(url, username, password);
  }

  /**
   * myemployees connection
   * @return
   */
  public static Connection getConnection() throws ClassNotFoundException, SQLException {
    String url = url1 + "myemployees" + url2;
    Class.forName(driver);
    return DriverManager.getConnection(url, username, password);
  }


  /**
   * 关流
   */
  public static void close(AutoCloseable... closeables) {
    for(AutoCloseable c: closeables) {
      try {
        if(null != c) {
          c.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
