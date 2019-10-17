package grammar;

import java.util.Arrays;

/**
 * @Deacription Object 数组
 * @Author BarryLee
 * @Date 2019/10/16 20:41
 */
public class G31ObjectArrayData {
  public static void main(String[] args) {
    Object[] em1 = {"01", "barry", 19};
    Object[] em2 = {"02", "barry2", 20};
    Object[] em3 = {"03", "barry3", 15};

    Object[][] obs = new Object[3][];
    obs[0] = em1;
    obs[1] = em2;
    obs[2] = em3;

    for(Object[] o: obs) {
      System.out.println(Arrays.toString(o));
    }

  }
}
