package grammar3.servlet;

import java.util.HashSet;
import java.util.Set;

/**
 * @Deacription Servlet-mapping
 * @Author BarryLee
 * @Date 2019/10/26 14:16
 */
public class ServletMapping {
  private String name;
  private Set<String> patterns;
  public ServletMapping() {
    patterns = new HashSet<>();
  }

  // 对外提供一个添加pattern方法，方便添加
  public void addPattern(String pattern) {
    patterns.add(pattern);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<String> getPatterns() {
    return patterns;
  }

  public void setPatterns(Set<String> patterns) {
    this.patterns = patterns;
  }

  @Override
  public String toString() {
    return "ServletMapping{" +
        "name='" + name + '\'' +
        ", patterns=" + patterns +
        '}';
  }
}
