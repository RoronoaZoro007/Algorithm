package CacheAlgorithm;

import java.util.HashMap;
import java.util.LinkedList;

public class LFUCache {

    HashMap<Integer, Node> keyCache;
    HashMap<Integer, LinkedList<Node>> freqCache;
    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyCache = new HashMap<>();
        freqCache = new HashMap<>();
    }

    public int get(int key) {
        if (capacity <= 0)
            return -1;
        if (keyCache.containsKey(key)) {
            Node node = removeAndAddFirst(key);
            return node.val;
        } else {
            return -1;
        }
    }

    private Node removeAndAddFirst(int key) {
        Node node = keyCache.get(key);
        int freq = node.freq;
        freqCache.get(freq).remove(node);
        if (freqCache.get(freq).size() == 0) {
            freqCache.remove(freq);
            if (minFreq == freq) {
                minFreq++;
            }
        }
        node.freq++;
        LinkedList<Node> list = freqCache.getOrDefault(freq + 1, new LinkedList<>());
        list.addFirst(node);
        freqCache.put(freq + 1, list);
        return node;
    }

    public void put(int key, int value) {
        if (capacity <= 0)
            return;
        if (keyCache.containsKey(key)) {
            Node node = removeAndAddFirst(key);
            node.val = value;
        } else {
            if (keyCache.size() >= capacity) {
                //大于容量，删除最小的，再put
                Node oldNode = freqCache.get(minFreq).pollLast();
                if (freqCache.get(minFreq).size() == 0) {
                    freqCache.remove(minFreq);
                }
                keyCache.remove(oldNode.key);
            }
            Node node = new Node(key, value, 1);
            keyCache.put(key, node);
            LinkedList<Node> list = freqCache.getOrDefault(1, new LinkedList<>());
            list.addFirst(node);
            freqCache.put(1, list);
            minFreq = 1;
        }
    }

    class Node {
        int key;
        int val;
        int freq;

        Node pre;
        Node next;

        public Node() {

        }

        public Node(int key, int val, int freq) {
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
    }

}
