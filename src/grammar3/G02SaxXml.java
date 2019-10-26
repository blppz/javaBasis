package grammar3;

import grammar3.servlet.Person;
import org.junit.Test;
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
 * @Deacription Sax 解析 Xml
 * @Author BarryLee
 * @Date 2019/10/26 9:28
 */
public class G02SaxXml {
  @Test
  public void test() throws ParserConfigurationException, SAXException, IOException {
    // 1.获取解析工厂
    SAXParserFactory factory = SAXParserFactory.newInstance();
    // 2.从解析工厂获取解析器
    SAXParser parser = factory.newSAXParser();
    // 3.编写处理器
    // 4.加载文档 Document 主存处理器
    PHandler handler = new PHandler();
    // 5.解析
    parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("grammar3/servlet/person.xml")
      , handler);

    List<Person> list = handler.getPersons();
    for(Person p: list) {
      System.out.println(p);
    }
  }
}
class PHandler extends DefaultHandler {
  private List<Person> list = new ArrayList<>();
  private String tag;
  private Person person;
  @Override
  public void startDocument() throws SAXException {
    //System.out.println("开始解析文档");
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    //System.out.println("开始解析节点：" + qName);
    if("name".equals(qName) || "age".equals(qName)) {
      tag = qName;
    }
    if("person".equals(qName)) {
      person = new Person();
    }
  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    String value = new String(ch, start, length).trim();
    if(tag != null && value.length() > 0) {
      if("name".equals(tag)) {
        person.setName(value);
      } else if("age".equals(tag)) {
        person.setAge(Integer.valueOf(value));
      }
    }
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    //System.out.println("结束解析节点：" + qName);
    if("person".equals(qName)) {
      list.add(person);
    }
  }

  @Override
  public void endDocument() throws SAXException {
    //System.out.println("解析文档结束");
  }

  /**
   * 获取文档解析的Persons
   * @return list
   */
  public List<Person> getPersons() {
    return list;
  }
}
