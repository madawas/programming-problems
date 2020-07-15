package org.madawa.practice.problems;

import org.madawa.util.LFUNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/lfu-cache/

Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.

Note that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted. This number is set to zero when the item is removed.

Follow up:
Could you do both operations in O(1) time complexity?
 */
public class LFUCache {
    private Map<Integer, LFUNode> cache;
    private Map<Integer, List<Integer>> freq;
    private int capacity;

    public LFUCache(int capacity) {
        this.cache = new HashMap<>();
        this.freq = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            LFUNode node = cache.get(key);
            this.removeFromFreq(node.freq, key); //remove from current frequency list
            node.freq += 1; //increment access frequency
            this.addToFreq(node.freq, key); // add key to the new frequency list
            return node.value;
        } else {
            return -1;
        }
    }

    public void remove(int key) {
        LFUNode node = cache.get(key);
        if (node == null)
            return;
        cache.remove(key);
        this.removeFromFreq(node.freq, key);
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;

        // We do a get here because it will update the frequency and you don't have to implement the same logic here.
        LFUNode node = (this.get(key) != -1) ? cache.get(key) : null;

        if (node != null) {
            node.value = value; // If the key exist, we only have to update the value as frequency changes has been done already.
        } else {
            if (cache.size() >= capacity) {
                List<Integer> keys = new ArrayList<>(freq.keySet());
                remove(freq.get(keys.get(0)).get(0)); //LFU item is the first entry as LHM keep the insertion order.
                //Every time a object is accessed from the cache, we remove the key from frequency map and insert it again.
                //Therefore frequently accessed objects will appear after least accessed objects.
            }
            node = new LFUNode(key, value);
            cache.put(key, node);
            this.addToFreq(node.freq, key);
        }
    }

    /**
     * Remove a key from the frequency map
     *
     * @param frequency frequency of the key to remove
     * @param key key to remove
     */
    private void removeFromFreq(int frequency, int key) {
        List<Integer> freqs = this.freq.get(frequency);
        freqs.remove(Integer.valueOf(key));
        if (freqs.isEmpty())
            this.freq.remove(frequency);
    }

    /**
     * Add a key to the frequency map
     *
     * @param frequency frequency of the key to add
     * @param key key to add
     */
    private void addToFreq(int frequency, int key) {
        if (freq.containsKey(frequency)) {
            freq.get(frequency).add(key);
        } else {
            List<Integer> freqList = new ArrayList<>();
            freqList.add(key);
            freq.put(frequency, freqList);
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
