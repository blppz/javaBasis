package grammar3.myServer.core;

import grammar3.servlet.Entity;
import grammar3.servlet.ServletMapping;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/27 11:36
 */

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
