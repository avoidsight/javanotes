package com.zp.leetcode;

import java.util.*;

class AllOne {
    private PriorityQueue queue;

    static class Node{
        public static Map<String, Node> map  = new HashMap<>();
        String key;
        Integer value;

        Node(String key, Integer value) {
            this.key = key;
            this.value = value;
            map.put(key, this);
        }

    }

    public AllOne() {
        queue = new PriorityQueue(Comparator.comparing((Node n) -> n.value));
    }

    public void inc(String key) {
        Node v = Node.map.get(key);
        if(v == null) {
            queue.offer(new Node(key,1));
            return;
        }
        queue.remove(v);
        queue.offer(new Node(key, v.value + 1));
    }

    public void dec(String key) {
        Node v = Node.map.get(key);
        if(v.value.equals(1)) {
            Node.map.remove(key);
            return;
        }
        queue.remove(v);
        queue.offer(new Node(key, v.value - 1));
    }

    public String getMaxKey() {
        return "";
    }

    public String getMinKey() {
        return "";
    }

    public static void main(String[] args) {

    }
}