package grammar;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/10/19 9:15
 */
public class G49BlHashMap {
  public static void main(String[] args) {
    BlHashMap map = new BlHashMap();
    map.put("1001", "老干妈");
    map.put("1002", "老干爹");
    map.put("1003", "葡萄干");
    //test1(map);
    test2(map);
    //test3(map);
  }
  public static void test3(BlHashMap map) {
    System.out.println(map.get("1001"));
    System.out.println(map.get("1002"));
    System.out.println(map.get("1003"));
    System.out.println(map.get("1004"));
  }
  public static void test2(BlHashMap map) {
    map.put("1002", "你懂的");
    map.put(2, "你真的懂了吗");
    System.out.println(map.toString());
    System.out.println(map.getSize());
  }
  public static void test1(BlHashMap map) {
    System.out.println(map.toString());
  }
}

/**
 * 节点
 */
class HashNode {
  public int hash;
  public Object key;
  public Object value;
  public HashNode next;
}

/**
 * 手动实现一个HashMap
 */
class BlHashMap {
  // 当前大小
  private int size;
  // 默认
  private static final int DEFAULT_CAPACITY = 16;
  // hashTable
  private HashNode[] table;

  public BlHashMap() {
    table = new HashNode[DEFAULT_CAPACITY];
  }

  /**
   * 添加元素
   * 思路：
   * 1.新建一个新的Node
   * 2.计算hash，也就是在哪一个桶
   * 3.如果这个桶还没有任何一个元素，就直接将新的Node放进去第一个
   * 4.如果这个桶已经有元素了，就需要进行遍历这个链表
   * 5.遍历过程中，如果key相等，就是value的替换，如果不等，就一直找到最后一个挂上去
   */
  public void put(Object key, Object value) {
    int hash = getHash(key.hashCode(), table.length);
    HashNode newNode = new HashNode();
    newNode.hash = hash;
    newNode.key = key;
    newNode.value = value;
    newNode.next = null;
    if(table[hash] == null) {
      table[hash] = newNode;
      size++;
    } else {
      HashNode temp = table[hash];
      while(temp != null) {
        if(temp.key.equals(newNode.key)) {
          temp.value = newNode.value;
          break;
        }
        if(temp.next == null) {
          temp.next = newNode;
          size++;
          break;
        }
        temp = temp.next;
      }
    }
  }

  /**
   * 根据key获取value
   * @param key key
   * @return value
   */
  public Object get(Object key) {
    Object value = null;
    int hash = getHash(key.hashCode(), table.length);
    HashNode temp = table[hash];
    while(temp != null) {
      if(temp.key.equals(key)) {
        value = temp.value;
        break;
      }
      temp = temp.next;
    }

    return value;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    if(size > 0) {
      sb.append("{ ");
      for(int i = 0; i < table.length; i++) {
        HashNode temp = table[i];
        while(temp != null) {
          sb.append(temp.key).append(": ").append(temp.value).append(", ");
          temp = temp.next;
        }
      }
      sb.replace(sb.length() - 2, sb.length() - 1, "");
      sb.append("}");
    } else {
      sb.append("{}");
    }

    return sb.toString();
  }

  public int getSize() {
    return size;
  }

  /**
   * 根据hashCode和桶的长度，获取hash值
   * @param hashCode -
   * @param length -
   * @return hash
   */
  private int getHash(int hashCode, int length) {
    //System.out.println(hashCode + ", " + (length-1) + " -> " + (hashCode & (length-1)));
    return hashCode & length - 1;
  }
}