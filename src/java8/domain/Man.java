package java8.domain;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/11/30 21:53
 */
public class Man {
  private Goddess goddess;

  @Override
  public String toString() {
    return "Man{" +
        "goddess=" + goddess +
        '}';
  }

  public Goddess getGoddess() {
    return goddess;
  }

  public void setGoddess(Goddess goddess) {
    this.goddess = goddess;
  }

  public Man() {
  }

  public Man(Goddess goddess) {
    this.goddess = goddess;
  }
}
