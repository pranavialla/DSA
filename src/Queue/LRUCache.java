package Queue;

import java.util.HashMap;
import java.util.Map;

import java.util.*;
class LRUCache {

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    Map<Integer, Node> map = new HashMap();
    int capacity;

    class Node{
        Node prev, next;
        int key, value;
        Node(int _key, int _value) {
            key = _key;
            value = _value;
            prev = null;
            next = null;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        //System.out.println("get : "+key);
        if(map.containsKey(key)) {
            Node node = map.get(key);
            removeAtDoubleLinkedListEndAndMap(node);
            insertInMapAndDoubleLinkedListStart(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        //System.out.println("put : "+key);
        if(map.containsKey(key)) {
            //System.out.println("key is present in map ");
            removeAtDoubleLinkedListEndAndMap(map.get(key));
        }
        if(map.size() == capacity) {
            //System.out.println("removing end" + capacity);
            removeAtDoubleLinkedListEndAndMap(tail.prev);
        }
        //System.out.println("inserting key ");
        insertInMapAndDoubleLinkedListStart(new Node(key, value));
    }

    private void removeAtDoubleLinkedListEndAndMap(Node node) {
        map.remove(node.key);

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertInMapAndDoubleLinkedListStart(Node node){
        map.put(node.key, node);

        Node headNext = head.next;
        head.next = node;
        node.prev = head;

        headNext.prev = node;
        node.next = headNext;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
