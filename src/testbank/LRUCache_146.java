package testbank;

import tools.*;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146 {
    /**
     * LRU 缓存机制， 利用哈希表 和 双链表
     * 哈希表用于O(1)时间随机访问
     * 双链表用于O(1)时间插入或者删除元素
     */
    LRUListNode head;
    LRUListNode tail;
    int capacity;
    Map<Integer, LRUListNode> map;

    /**
     * 初始化
     *
     * @param capacity 容量
     */
    public LRUCache_146(int capacity) {
        head = new LRUListNode();
        tail = new LRUListNode();
        head.rear = tail;
        tail.previous = head;
        this.capacity = capacity;
        map = new HashMap<>();
    }

    /**
     * 1. 如果没有找到map中的key，返回-1
     * 2. 如果找到，将根据map获取制定结点，并将该结点置于head后
     *
     * @param key
     * @return key:value
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            LRUListNode temp = map.get(key);
            temp.previous.rear = temp.rear;
            temp.rear.previous = temp.previous;
            temp.rear = head.rear;
            head.rear = temp;
            temp.rear.previous = temp;
            temp.previous = head;
            return temp.value;
        } else {
            return -1;
        }
    }

    /**
     * 1. 出找map是否有该元素，有则更改值，并更新结点在链表中的位置
     * 没有则进入第二步
     * 2. 检测map元素是否达到capacity数量，没有则直接新增结点，
     * 置入map与链表中，否则进入第三步
     * 3. 查找最后尾结点key，删除尾结点，删除map中该键值对
     * 新增节点，置于map与链表中
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            LRUListNode temp = map.get(key);
            temp.value = value;
            temp.previous.rear = temp.rear;
            temp.rear.previous = temp.previous;
            temp.rear = head.rear;
            head.rear = temp;
            temp.rear.previous = temp;
            temp.previous = head;
            return;
        } else {
            LRUListNode new_node = new LRUListNode(key, value);
            new_node.rear = head.rear;
            head.rear = new_node;
            new_node.rear.previous = new_node;
            new_node.previous = head;

            map.put(key, new_node);

            if (map.size()>capacity){
                LRUListNode delete_node = tail.previous;
                delete_node.previous.rear = tail;
                tail.previous = delete_node.previous;

                delete_node.previous = null;
                delete_node.rear = null;

                map.remove(delete_node.key);
            }
        }


    }

}
