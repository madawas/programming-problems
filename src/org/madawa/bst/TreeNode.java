package org.madawa.bst;

public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void insert(int value) {
        if (value >= this.value) {
            if (this.right == null)
                this.right = new TreeNode(value);
            else
                this.right.insert(value);
        } else {
            if (this.left == null)
                this.left = new TreeNode(value);
            else
                this.left.insert(value);
        }
    }

    public TreeNode search(int value) {
        if (this.value == value) {
            return this;
        } else if (value > this.value && this.right != null) {
            return this.right.search(value);
        } else if (value < this.value && this.left != null) {
            return this.left.search(value);
        }
        return null;
    }

    public void inorder() {
        if (this.left != null) {
            this.left.inorder();
        }
        System.out.print(this.value + " ");
        if (this.right != null) {
            this.right.inorder();
        }
    }

}
