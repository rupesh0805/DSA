package Design;

/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:
    LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    int get(int key) Return the value of the key if the key exists, otherwise return -1.
    void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
    The functions get and put must each run in O(1) average time complexity.
*/


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}


class LRUCacheManual {
    int capacity;
    Map<Integer, ListNode> dic;
    ListNode head;
    ListNode tail;

    public LRUCacheManual(int capacity) {
        this.capacity = capacity;
        dic = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!dic.containsKey(key)) {
            return -1;
        }

        ListNode node = dic.get(key);
        remove(node);
        add(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (dic.containsKey(key)) {
            ListNode oldNode = dic.get(key);
            remove(oldNode);
        }

        ListNode node = new ListNode(key, value);
        dic.put(key, node);
        add(node);

        if (dic.size() > capacity) {
            ListNode nodeToDelete = head.next;
            remove(nodeToDelete);
            dic.remove(nodeToDelete.key);
        }
    }

    public void add(ListNode node) {
        ListNode previousEnd = tail.prev;
        previousEnd.next = node;
        node.prev = previousEnd;
        node.next = tail;
        tail.prev = node;
    }

    public void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}





public class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> dic;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dic = new LinkedHashMap(10, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size()>capacity;
            }
        };
    }

    public int get(int key) {
        return dic.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        dic.put(key, value);
    }

}


class Node {
    int key;
    int val;
    Node next;
    Node prev;
    Node(int key,int val){
        this.key = key;
        this.val = val;
    }
}


class LRUCacheMine {
    int cap;
    Map<Integer,Node> map;
    Node head;
    Node tail;

    public LRUCacheMine(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        head = new Node(-1,-1);
        head.next = new Node(-1,-1);
        tail = head.next;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node curr =  map.get(key);
        int val = curr.val;

        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        curr.prev = tail.prev;
        curr.prev.next = curr;
        curr.next = tail;
        tail.prev = curr;
        return val;
    }

    public void put(int key, int value) {
        Node newNode = null;
        if(!map.containsKey(key)){
            if(map.size()==cap){
                Node toRemove = head.next;
                head.next = toRemove.next;
                toRemove.next.prev = head;
                map.remove(toRemove.key);
            }
            newNode = new Node(key,value);
        }
        else{
            newNode = map.get(key);
            newNode.prev.next = newNode.next;
            newNode.next.prev = newNode.prev;
        }

        newNode.val = value;
        map.put(key,newNode);
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        newNode.next = tail;
        tail.prev = newNode;
    }
}




