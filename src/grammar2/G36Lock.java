package grammar2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/24 8:57
 */
public class G36Lock {

  /**
   * 可重入锁：
   */

  private static Lock lock = new Lock();
  private static ReLock reLock = new ReLock();
  public static void main(String[] args) throws InterruptedException {
    // a();
    m();

    ReentrantLock l;
  }
  ////////////////////////////////
  public static void m() throws InterruptedException {
    reLock.lock();
    System.out.println("m lock ->" + reLock.getHoldCount());
    n();
    reLock.unlock();
    System.out.println("m unlock ->" + reLock.getHoldCount());
  }
  public static void n() throws InterruptedException {
    reLock.lock();
    System.out.println("n lock ->" + reLock.getHoldCount());
    reLock.unlock();
    System.out.println("n unlock ->" + reLock.getHoldCount());
  }

  // 可重入锁
  static class ReLock {
    private boolean isLock = false;
    private Thread lockedBy;
    private int holdCount;
    public synchronized void lock() throws InterruptedException {
      Thread thread = Thread.currentThread();
      while(isLock && thread != lockedBy) {
        this.wait();
      }
      lockedBy = thread;
      holdCount++;
    }
    public synchronized void unlock() {
      if(lockedBy == Thread.currentThread() && --holdCount == 0) {
        lockedBy = null;
        isLock = false;
      }
    }
    public int getHoldCount() {
      return holdCount;
    }
  }
  /////////////////////////////////////////

  // 不可重入锁Demo
  public static void a() throws InterruptedException {
    lock.lock();
    System.out.println("a lock");
    b();
    lock.unLock();
    System.out.println("a unlock");
  }
  public static void b() throws InterruptedException {
    lock.lock();
    System.out.println("unlock");
    lock.unLock();
  }

  // 不可重入锁
  static class Lock {
    private boolean isLock = false;
    public Lock() {}
    // 加锁
    public synchronized void lock() throws InterruptedException {
      while(isLock) {
        this.wait();
      }
      isLock = true;
    }
    // 解锁
    public synchronized void unLock() throws InterruptedException {
      isLock = false;
      this.notify();
    }
  }
}
