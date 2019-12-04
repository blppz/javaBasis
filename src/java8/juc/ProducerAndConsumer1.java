package java8.juc;

/**
 * @Deacription 生产者和消费者
 * @Author BarryLee
 * @Date 2019/12/2 16:13
 */

/**
 * 注意虚假唤醒的问题 - 可以在文档上看到应该使用while提代if来解决
 */
public class ProducerAndConsumer1 {
  public static void main(String[] args) {
    Clerk1 clerk1 = new Clerk1();
    new Thread(new Producer(clerk1)).start();
    new Thread(new Consumer(clerk1)).start();
    new Thread(new Producer(clerk1)).start();
    new Thread(new Consumer(clerk1)).start();
  }
}
// 店员，负责进货和售卖商品
class Clerk1 {
  int num = 0;
  public synchronized void stock() {
    //if(num >= 1) { --- 使用if会导致虚假唤醒，
    // 也就是比如两个消费者在等待，而一个生产者会同时叫醒他们，这就会产生负数的情况
    while(num >= 1) {
      try {
        System.out.println("满了 ..");
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println(++num);
    this.notifyAll();
  }
  public synchronized void sale() {
    //if(num<=0) {
    while(num<=0) {
      try {
        System.out.println("没了 ..");
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println(--num);
    this.notifyAll();
  }
}
// 生产者
class Producer implements Runnable{
  private Clerk1 clerk1;
  Producer(Clerk1 clerk1) {
    this.clerk1 = clerk1;
  }
  @Override
  public void run() {
    for(int i = 0; i<10; i++) {
      clerk1.stock();
    }
  }
}
// 消费者
class Consumer implements Runnable {
  private Clerk1 clerk1;
  Consumer(Clerk1 clerk1) {
    this.clerk1 = clerk1;
  }
  @Override
  public void run() {
    for(int i = 0; i<10; i++) {
      clerk1.sale();
    }
  }
}