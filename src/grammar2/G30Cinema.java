package grammar2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/22 22:51
 */
public class G30Cinema {
  /**
   * 模拟电影院购票
   */
  public static void main(String[] args) {
    List<Integer> cinemaSeats = new ArrayList<>();
    cinemaSeats.add(1);
    cinemaSeats.add(2);
    cinemaSeats.add(3);
    cinemaSeats.add(4);
    cinemaSeats.add(6);
    cinemaSeats.add(9);
    cinemaSeats.add(10);
    Cinema cinema = new Cinema(cinemaSeats, "BL-IMAX");

    List<Integer> c1List = new ArrayList<>();
    c1List.add(1);
    c1List.add(2);
    List<Integer> c2List = new ArrayList<>();
    c2List.add(4);
    c2List.add(6);
    c2List.add(10);
    Customer c1 = new Customer(cinema, "老干妈", c1List);
    Customer c2 = new Customer(cinema, "loveCinema", c2List);

    new Thread(c1).start();
    new Thread(c2).start();
  }
  static class Customer implements Runnable {
    String name;
    List<Integer> seats;
    Cinema cinema;
    public Customer(Cinema cinema, String name, List<Integer> seats) {
      this.name = name;
      this.seats = seats;
      this.cinema = cinema;
    }

    @Override
    public void run() {
      if(cinema.bookTicket(seats)) {
        System.out.println(name + ": 订到了" + seats + "张票" );
      } else {
        System.out.println(name + "gg，没票了");
      }
    }
  }
  static class Cinema {
    List<Integer> seats;
    String name;
    public Cinema(List<Integer> seats, String name) {
      this.seats = seats;
      this.name = name;
    }
    public boolean bookTicket(List<Integer> needSeats) {
      List<Integer> copy = new ArrayList<>();
      copy.addAll(seats);
      copy.removeAll(needSeats);
      if(seats.size() - copy.size() != needSeats.size()) {
        return false;
      }

      synchronized (this) {
        copy = new ArrayList<>();
        copy.addAll(seats);
        copy.removeAll(needSeats);
        if(seats.size() - copy.size() != needSeats.size()) {
          return false;
        }

        try {
          Thread.sleep(1500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        seats = copy;
        System.out.println(name + "余票：" + this.seats);
        return true;
      }
    }
  }
}
