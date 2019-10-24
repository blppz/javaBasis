package grammar2;

/**
 * @Deacription 生产者消费者Demo
 * @Author BarryLee
 * @Date 2019/10/23 11:41
 */
public class G32Producers_Consumers {
  private static int num = 3;
  public static void main(String[] args) {
    Container container = new Container();
    Producer producer = new Producer(container);
    Consumer consumer = new Consumer(container);

    new Thread(producer).start();
    new Thread(consumer).start();
  }
  // 生产者
  static class Producer implements Runnable {
    private Container container;
    public Producer(Container container) {
      this.container = container;
    }
    @Override
    public void run() {
      for(int i = 0; i < num; i++) {
        container.production(i);
        System.out.println("生产: " + i);
      }
    }
  }
  // 消费者
  static class Consumer implements Runnable {
    private Container container;
    public Consumer(Container container) {
      this.container = container;
    }
    @Override
    public void run() {
      for(int i = 0; i < num; i++) {
        System.out.println("消费：" + container.pop().id);
      }
    }
  }
  // 容器
  static class Container {
    // 容器
    Love[] loves = new Love[10];
    // 容器中有几个产品
    int count = 0;
    // 构造
    public Container(){}
    // 获取爱
    synchronized public Love pop() {
      // 什么条件可以获取
      if(count <= 0) {
        try {
          this.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      this.notifyAll();
      return loves[--count];
    }
    // 生产爱
    synchronized public void production(int id) {
      // 什么条件可以生产
      if(count >= loves.length) {
        try {
          this.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      loves[count++] = new Love(id);
      this.notifyAll();
    }
  }
  // 放在容器中的Love数据
  static class Love {
    int id;
    public Love(int id) {
      this.id = id;
    }
  }
}
