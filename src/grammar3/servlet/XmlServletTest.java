package grammar3.servlet;

import grammar3.myServer.core.WebContext;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/26 14:07
 */
public class XmlServletTest {
  public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
    // 1.获取解析工厂
    SAXParserFactory factory = SAXParserFactory.newInstance();
    // 2.从解析工厂获取解析器
    SAXParser parser = factory.newSAXParser();
    // 3.编写处理器
    // 4.加载文档 Document 主存处理器
    WebHandler handler = new WebHandler();
    // 5.解析
    parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("grammar3/servlet/web.xml")
        , handler);

    // 6.处理结果
    WebContext context = new WebContext(
        handler.getServletList(),
        handler.getMappingList()
    );
    Class<?> clazz = Class.forName(context.getClazz("/register"));
    Servlet servlet = (Servlet)clazz.newInstance();
    servlet.service();
  }
}

class WebHandler extends DefaultHandler {
  private List<Entity> servletList = new ArrayList<>();
  private List<ServletMapping> mappingList = new ArrayList<>();
  // 当前标签是什么
  private String tag;
  // 区分servlet 和 entity-mapping
  private boolean isMapping;

  private Entity entity;
  private ServletMapping mapping;

  @Override
  public void startDocument() {
    //System.out.println("开始解析文档");
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    //System.out.println("开始解析节点：" + qName);
    if("servlet".equals(qName)) {
      isMapping = false;
      entity = new Entity();
      return;
    } else if("servlet-mapping".equals(qName)) {
      isMapping = true;
      mapping = new ServletMapping();
      return;
    }

    if(!isMapping) {
      if("servlet-name".equals(qName) || "servlet-class".equals(qName)) {
        tag = qName;
      }
    } else {
      if("servlet-name".equals(qName) || "url-pattern".equals(qName)) {
        tag = qName;
      }
    }
  }

  @Override
  public void characters(char[] ch, int start, int length) {
    String value = new String(ch, start, length).trim();
    if(tag != null && value.length() > 0) {
      if(!isMapping) {
        if("servlet-name".equals(tag)) {
          entity.setName(value);
        } else if("servlet-class".equals(tag)) {
          entity.setClazz(value);
        }
      }else {
        if("servlet-name".equals(tag)) {
          mapping.setName(value);
        } else if("url-pattern".equals(tag)) {
          mapping.addPattern(value);
        }
      }
    }
  }

  @Override
  public void endElement(String uri, String localName, String qName) {
    //System.out.println("结束解析节点：" + qName);
    if("servlet".equals(qName)) {
      servletList.add(entity);
    } else if("servlet-mapping".equals(qName)) {
      mappingList.add(mapping);
    }
  }

  @Override
  public void endDocument() {
    //System.out.println("解析文档结束");
  }

  /**
   * 获取文档解析的ServletList
   * @return list
   */
  public List<Entity> getServletList() {
    return servletList;
  }
  /**
   * 获取文档解析的MappingList
   * @return list
   */
  public List<ServletMapping> getMappingList() {
    return mappingList;
  }
}
