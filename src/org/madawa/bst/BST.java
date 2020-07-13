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

    public void delete(int value) {
        TreeNode current = this.root;
        TreeNode parent = this.root;
        boolean isLeftChild = false;

        if (current == null)
            return;

        while(current != null && current.getValue() != value) {
            parent = current;
            if (value < current.getValue()) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.getRight();
                isLeftChild = false;
            }
        }

        if (current == null) {
            return;
        }

        if (current.getLeft() == null && current.getRight() == null) {
            if (current == root) {
                root = null;
            } else {
                if (isLeftChild) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
            }
        } else if (current.getRight() == null) {
            if (current == root) {
                root = root.getLeft();
            } else if (isLeftChild){
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }
        } else if (current.getLeft() == null) {
            if (current == root) {
                root = root.getRight();
            } else if (isLeftChild){
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }
        }
    }

    public void inorder() {
        if (this.root != null) {
            this.root.inorder();
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

        bst.inorder();
    }
}
