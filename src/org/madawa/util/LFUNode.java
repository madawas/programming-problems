package org.madawa.util;

public class LFUNode {
    public int key;
    public int value;
    public int freq;

    public LFUNode(int k, int v) {
        this.key = k;
        this.value = v;
        this.freq = 1;
    }
}
