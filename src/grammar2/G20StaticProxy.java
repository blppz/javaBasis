package grammar2;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/21 22:32
 */
public class G20StaticProxy {
  /**
   * 静态代理
   * 静态代理的类是写好了的，直接拿过来用，比如Thread类
   *
   * 这里的例子是，You去结婚，WeddingCompany婚礼公司为你忙前忙后
   * 这里You就是被代理的对象，婚礼公司就是代理类，但是，结婚的还是You
   * 他们实现同一个接口wedding
   */
  public static void main(String[] args) {
    new WeddingCompany(new You()).wedding();
    //new Thread(new MyRunnabel());
  }

  static interface Wedding {
    void wedding();
  }
  static class You implements Wedding{

    @Override
    public void wedding() {
      System.out.println("洞房花烛");
    }
  }
  static class WeddingCompany implements Wedding{

    private Wedding w;
    public WeddingCompany(Wedding w) {
      this.w = w;
    }
    @Override
    public void wedding() {
      System.out.println("忙前。。。");
      w.wedding();
      System.out.println("忙后。。。");
    }
  }
}
