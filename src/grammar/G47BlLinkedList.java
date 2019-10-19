package grammar;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/18 14:23
 */
public class G47BlLinkedList {
  public static void main(String[] args) {
    BblLinkedList<String> list = new BblLinkedList<>();
    list.add("老干妈");
    list.add("杜子腾");
    list.add("崔空迢");
    list.add("曼哈顿博士");
    System.out.println(list.toString());
    //System.out.println(list.get(0).element);
    //System.out.println(list.get(1).element);
    //System.out.println(list.get(2).element);
    //System.out.println(list.get(3).element);

    list.add(0, "雷神他弟");
    System.out.println(list.toString());
    //
    //System.out.println("----------------------");

    list.remove(0);
    System.out.println(list.toString());
    list.remove(list.size() - 1);
    System.out.println(list.toString());
    list.remove(1);
    System.out.println(list.toString());
  }
}

class Node {
  public Node prev;
  public Node next;
  public Object element;
  public Node(Object element) {
    this.element = element;
  }
}

/**
 * 都没有考虑size为0或者1的情况，只考虑了多个元素，首尾、中间元素的操作
 * @param <E>
 */
class BblLinkedList<E> {
  // 链表长度
  private int size;
  // 链表头
  private Node head;
  // 链表尾
  private Node tail;

  // 1.构造
  public BblLinkedList() {
  }

  private void ensureSize(int index) {
    if(index < 0 || index >= size) {
      throw new RuntimeException("索引下标错误：" + index);
    }
  }

  // 2.添加元素

  /**
   * 只传入单个元素，在表尾添加
   * @param element element
   */
  public void add(E element) {
    Node newNode = new Node(element);
    if(head == null) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode;
    }
    size++;
  }

  /**
   * 指定坐标，在指定坐标添加元素
   * @param index index
   * @param element element
   */
  public void add(int index, E element) {
    ensureSize(index);
    Node newNode = new Node(element);
    Node nextNode = get(index);

    if(index == 0) {
      newNode.next = nextNode;
      nextNode.prev = newNode;
      head = newNode;
    } else {
      Node prevNode = nextNode.prev;
      prevNode.next = newNode;
      newNode.prev = prevNode;
      newNode.next = nextNode;
      nextNode.prev = newNode;
    }

    size++;
  }

  // 3.获取元素
  public Node get(int index) {
    ensureSize(index);
    int half = size>>1;
    Node cur = null;
    if(index <= half) {
      cur = head;
      for(int i = 0; i <= half; i++) {
        if(i == index) {
          break;
        }
        cur = cur.next;
      }
    }else {
      cur = tail;
      for(int i = size-1; i > half; i--) {
        if(i == index) {
          break;
        }
        cur = cur.prev;
      }
    }

    return cur;
  }

  // 4.删除元素
  public Node remove(int index) {
    ensureSize(index);
    Node curNode = get(index);
    if(index == 0) {
      Node nextNode = curNode.next;
      nextNode.prev = null;
      curNode.next = null;
      head = nextNode;
    } else if(index == size - 1) {
      Node prevNode = curNode.prev;
      prevNode.next = null;
      curNode.prev = null;
      tail = prevNode;
    } else {
      Node prevNode = curNode.prev;
      Node nextNode = curNode.next;
      prevNode.next = nextNode;
      nextNode.prev = prevNode;
    }
    size--;

    return curNode;
  }

  // 5.打印
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    Node tempNode = head;
    for(int i = 0; i < size; i++) {
      sb.append(tempNode.element).append(",");
      tempNode = tempNode.next;
    }
    sb.setCharAt(sb.length()-1, ']');
    return sb.toString();
  }

  // 获取长度
  public int size() {
    return size;
  }
}
