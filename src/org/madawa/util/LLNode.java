package org.madawa.util;

class LLNode {
    public int key;
    public int value;
    public LLNode next;
    public LLNode prev;

    public LLNode() {

    }

    public LLNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
