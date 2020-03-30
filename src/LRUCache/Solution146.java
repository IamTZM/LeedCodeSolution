package LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 *
 * @author Steph
 * @date 2020/2/13 21:57
 */
public class Solution146 {

}

/**
 * The definition of LRU Cache
 */
class LRUCache {
    /**
     * Double Linked List Node
     */
    class DLNode {
        int key, value;
        DLNode pre, post;
    }

    private Map<Integer, DLNode> cache;
    private int capacity, size;
    private DLNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        cache = new HashMap<>();
        head = new DLNode();
        tail = new DLNode();
        head.pre = null;
        tail.post = null;
        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLNode node = cache.get(key);
        if (node == null)
            return -1;

        this.moveToHead(node);
        return node.value;

    }

    public void put(int key, int value) {
        DLNode node = cache.get(key);
        if (node == null) {
            node = new DLNode();
            node.key = key;
            node.value = value;
            addHead(node);
            cache.put(key, node);
            size++;
            if (size > capacity) {
                DLNode tmp = popTail();
                cache.remove(tmp.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addHead(DLNode node) {
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
        node.pre = head;
    }

    private void removeDLNode(DLNode node) {
        node.pre.post = node.post;
        node.post.pre = node.pre;
    }

    private void moveToHead(DLNode node) {
        removeDLNode(node);
        addHead(node);
    }

    private DLNode popTail() {
        DLNode node = tail.pre;
        removeDLNode(node);
        return node;
    }

}