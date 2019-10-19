package grammar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Deacription Collections
 * @Author BarryLee
 * @Date 2019/10/19 21:32
 */
public class G53Collections {
  /**
   * Collections是个工具类（辅助类）
   */
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    for(int i = 0; i < 10; i++ ){
      list.add("Lee" + i);
    }
    System.out.println(list);

    // 1.打乱顺序
    Collections.shuffle(list);
    System.out.println(list);

    // 2.逆序
    Collections.reverse(list);
    System.out.println(list);

    // 3.排序（另外，还可以加比较器的）
    Collections.sort(list);
    System.out.println(list);

    // 4.二分查找
    int idx = Collections.binarySearch(list, "Lee3");
    System.out.println(idx);

    //
    Collections.fill(list, "barry");
    System.out.println(list);

  }
}
