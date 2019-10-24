package grammar2;

/**
 * @Deacription 概念
 * @Author BarryLee
 * @Date 2019/10/21 17:16
 */
public class G15ThreadConcept {
  /**
   * 很多多线程都是模拟出来的，真正的多线程是指有多个CPU即多核
   * 如果只有一个CPU，其实同一时间点只会在执行一个任务
   *
   * 进程是针对操作系统来讲的
   * 每个线程都有自己的工作空间
   *
   * 创建线程的三种方式
   * 1.继承Thread类，重写run方法
   * 2.实现Runnable接口，重写run方法
   * 3.实现Callable接口，重写call方法
   *
   * 我们需要调用的是start方法，start方法内部会调用run
   * 但是如果不小心手动调用了run方法，就会发现我们并没有新的线程执行run方法里面的内容，也就是普通方法的调用
   *
   * start()方法官方解释：导致此线程开始执行; Java虚拟机调用此线程的run方法。
   * 也就是说start方法不是启动了线程，而是通知
   *
   * 线程状态相关概念
   * 1.新生态：new之后进入新生态
   * 2.就绪态：start方法调用时候进入就绪态
   * 3.运行态：获取到了CPU时间片（调度器调度）
   * 4.阻塞态：1.其他阻塞sleep/join、IO（read, write）、2.等待阻塞wait --notify-> 3.同步阻塞synchronized
   * 5.死亡态：程序正常执行完毕、stop()
   * 这些状态在API中由具体参数，其中就绪和运行都是Runnable
   */
  public static void main(String[] args) {
    // 简单测试多线程
    G15Thread t1 = new G15Thread();
    t1.start();

    G15Runnable t2 = new G15Runnable();
    new Thread(t2).start();

    int n = 10;
    while(n-- > 0) {
      System.out.println("coding");
    }
  }
}

class G15Thread extends Thread{
  @Override
  public void run() {
    int n = 10;
    while(n-- > 0) {
      System.out.println("听歌");
    }
  }
}

class G15Runnable implements Runnable {

  @Override
  public void run() {
    int n = 10;
    while(n-- > 0) {
      System.out.println("撩妹");
    }
  }
}