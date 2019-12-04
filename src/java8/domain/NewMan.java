package java8.domain;

import java.util.Optional;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/11/30 22:00
 */
public class NewMan {
  // 如果不给定empty，则godness是null
  private Optional<Goddess> goddess = Optional.empty();

  public NewMan() {
  }

  public NewMan(Optional<Goddess> goddess) {
    this.goddess = goddess;
  }

  @Override
  public String toString() {
    return "NewMan{" +
        "goddess=" + goddess +
        '}';
  }

  public Optional<Goddess> getGoddess() {
    return goddess;
  }

  public void setGoddess(Optional<Goddess> goddess) {
    this.goddess = goddess;
  }
}
