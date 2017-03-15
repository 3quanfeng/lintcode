public class Solution {

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    private int size;
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private Map<Integer, Node> map = new HashMap<Integer, Node>();
    // @param capacity, an integer
    public Solution(int capacity) {
        // write your code here
        this.size = capacity;
        head.next = tail;
        tail.prev = head;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if (!map.containsKey(key)) {
            return -1;
        }
        Node cur = map.get(key);
        cur.next.prev = cur.prev;
        cur.prev.next = cur.next;
        moveToTail(cur);
        return cur.value;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        if (map.size() == size) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        Node insert = new Node(key, value);
        map.put(key, insert);
        moveToTail(insert);
    }
    private void moveToTail(Node cur) {
        cur.next = tail;
        cur.prev = tail.prev;
        cur.next.prev = cur;
        cur.prev.next = cur;
    }
}