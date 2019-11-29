package grammar;

import java.util.Arrays;

import org.junit.Test;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/31 10:21
 */
public class G55Arrays {
  @Test
  public void test1() {
    int[] ints = Arrays.copyOf(new int[]{1, 2, 3}, 2);
    System.out.println(Arrays.toString(ints));

    int[] arr = new int[] {1,3,5,7,9,112};
    int i = Arrays.binarySearch(arr, 112);
    System.out.println(i);

    arr = new int[] {5,1,7,34,100,-10};
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
