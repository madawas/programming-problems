package org.madawa.bst;

public class BST {
    private TreeNode root;

    public TreeNode search(int value) {
        if (this.root != null) {
            return this.root.search(value);
        }
        return null;
    }

    public void insert(int value) {
        if (this.root == null) {
            this.root = new TreeNode(value);
        } else {
            this.root.insert(value);
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(6);
        bst.insert(8);
        bst.insert(4);
        bst.insert(5);
        bst.insert(7);
        bst.insert(15);

        TreeNode node = bst.search(15);
        if (node != null) {
            System.out.println(node.value);
        } else {
            System.out.println(-1);
        }
    }
}
