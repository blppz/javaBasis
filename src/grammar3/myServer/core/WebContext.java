package grammar3.myServer.core;

import grammar3.servlet.Entity;
import grammar3.servlet.ServletMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/26 15:14
 */
public class WebContext {
  private List<Entity> entityList;
  private List<ServletMapping> mappingList;

  private Map<String, String> entityMap;
  private Map<String, String> mappingMap;

  public WebContext(List<Entity> entityList, List<ServletMapping> mappingList) {
    this.entityList = entityList;
    this.mappingList = mappingList;
    entityMap = new HashMap<>();
    mappingMap = new HashMap<>();
    init();
  }
  // 将数据封装到两个map中，方便处理
  private void init() {
    for(Entity entity: entityList) {
      entityMap.put(entity.getName(), entity.getClazz());
    }
    for(ServletMapping mapping: mappingList) {
      for(String pattern: mapping.getPatterns()) {
        mappingMap.put(pattern, mapping.getName());
      }
    }
  }
  // 对外提供通过pattern获取Class的方法
  public String getClazz(String pattern) {
    return entityMap.get(mappingMap.get(pattern));
  }
}
