package grammar;

import util.Utils;

import java.util.Arrays;

/**
 * @Deacription 数组
 * @Author BarryLee
 * @Date 2019/10/16 19:29
 */
public class G30Array {
  public static void main(String[] args) {
    int[] srcArray = new int[] {1, 2, 3, 4};
    int[] destArray = new int[] {6, 7, 8, 9};
    System.arraycopy(srcArray, 2, destArray, 1, 2);

    Utils.printArray(srcArray);
    Utils.printArray(destArray);

    System.out.println("---------------");

    int[] testDel = new int[] {1, 2, 3};
    deleteElement(testDel, 1);
    Utils.printArray(testDel);

    String[] testExtent = {"a", "b", "c"};
    testExtent = extentsArray(testExtent, 3);
    String res = Arrays.toString(testExtent);
    System.out.println(res);
  }

  /**
   * 删除数组中的元素
   * @param arr array
   * @return array
   */
  public static void deleteElement(int[] arr, int index) {
    System.arraycopy(arr, index + 1, arr, index, arr.length-index - 1);
    arr[arr.length - 1] = 0;
  }

  /**
   * 给数组扩容
   * @param arr array
   * @param len length
   * @return new array
   */
  public static String[] extentsArray(String[] arr, int len) {
    String[] res = new String[arr.length + len];
    System.arraycopy(arr, 0, res, 0, arr.length);
    return res;
  }
}
