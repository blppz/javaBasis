package grammar;

import java.util.Arrays;

/**
 * @Deacription 自定义arrayList
 * @Author BarryLee
 * @Date 2019/10/18 9:21
 */
public class G45BlArrayList {
  public static void main(String[] args) {
    BlArrayList<String> list = new BlArrayList<>();
    list.add("老干妈");
    list.add("老干爹");
    list.add("雷神");
    list.add("锁儿");

    System.out.println(list.toString());

    // test remove
    list.remove(3);
    System.out.println(list.toString());
  }
}

class BlArrayList<E> {
  private Object[] elementData;
  private int size = 0;
  private static final int DEFAULT_CAPACITY = 2;

  public BlArrayList() {
    elementData = new Object[DEFAULT_CAPACITY];
  }

  public BlArrayList(int length) {
    if(length < 0) {
      throw new RuntimeException("长度非法：" + length);
    } else if(length == 0) {
      elementData = new Object[DEFAULT_CAPACITY];
    } else {
      elementData = new Object[length];
    }
  }

  public void set(int index, E e) {
    checkRange(index);
    elementData[index] = e;
  }

  public E get(int index) {
    checkRange(index);
    return (E) elementData[index];
  }

  public void add(E element) {
    ensureSize();
    elementData[size++] = element;
  }

  /**
   * 移除下标为index的element
   * @param index index
   * @return E
   */
  public E remove(int index) {
    checkRange(index);
    int len = elementData.length;
    Object o = elementData[index];

    Object[] tempObjs = new Object[len];
    System.arraycopy(elementData, 0, tempObjs, 0, index);
    System.arraycopy(elementData, index + 1, tempObjs, index, size-index-1);

    size--;
    elementData = tempObjs;
    return (E)o;
  }

  private void checkRange(int index) {
    if(index < 0 || index > size - 1) {
      throw new RuntimeException("索引错误：" + index);
    }
  }

  private void ensureSize() {
    if(elementData.length == size + 1) {
      grow(elementData.length);
    }
  }

  /**
   * 数组扩容
   */
  private void grow(int oldCapacity) {
    int newCapacity = oldCapacity + (oldCapacity>>1);
    System.out.println(newCapacity);
    elementData = Arrays.copyOf(elementData, newCapacity);
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for(int i = 0; i < size; i++) {
      sb.append(elementData[i]).append(",");
    }
    sb.setCharAt(sb.length()-1, ']');

    return sb.toString();
  }
}