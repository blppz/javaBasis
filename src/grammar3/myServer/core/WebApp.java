package grammar3.myServer.core;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/27 11:19
 */
public class WebApp {
  private static WebContext context;
  static {
    try {
      SAXParserFactory factory = SAXParserFactory.newInstance();
      SAXParser parser = factory.newSAXParser();
      WebHandler handler = new WebHandler();
      // 这个名字为web.xml就报错，空指针，拿不到inputStream!!，这个何解
      parser.parse(Thread.currentThread().getContextClassLoader()
          .getResourceAsStream("grammar3/myServer/othreFile/webInfo.xml"), handler);
      context = new WebContext(
          handler.getServletList(),
          handler.getMappingList()
      );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 通过解析xml来获取指定url的servlet类实例
   * @param url
   * @return
   */
  public static Servlet getServletFromUrl(String url) {
    Servlet servlet = null;
    if(null != url && url.length() > 0) {
      Class<?> clazz;
      try {
        String name = context.getClazz("/" + url);
        if(name != null) {
          clazz = Class.forName(name);
          servlet = (Servlet) clazz.newInstance();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return servlet;
  }
}
