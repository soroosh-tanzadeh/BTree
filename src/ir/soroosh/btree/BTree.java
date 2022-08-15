package ir.soroosh.btree;

import java.util.ArrayList;

public class BTree {

    public Node root;
    private int depth = -1;

    private boolean unique;

    private ArrayList<Integer> sorted = new ArrayList<>();

    public BTree(boolean unique) {
        this.unique = unique;
    }

    public BTree() {
        this.unique = false;
    }

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            this.insert(data, root);
        }
    }

    private Node insert(int data, Node root) {
        if (root == null) {
            root = new Node(data);
            return root;
        } else {
            if (data > root.data) {
                root.leftNode = insert(data, root.leftNode);
            } else if(data < root.data) {
                root.rightNode = insert(data, root.rightNode);
            }else{
                if(this.unique){
                    throw new RuntimeException(data + " previously added");
                }else{
                    root.rightNode = insert(data, root.rightNode);
                }
            }
        }
        depth++;
        return root;
    }

    public void inOrder() {
        this.inOrder(root);
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.leftNode);
            this.sorted.add(root.data);
            inOrder(root.rightNode);
        }
    }

    public ArrayList<Integer> getSorted() {
        this.inOrder();
        return sorted;
    }

    public class Node {
        public Node leftNode;
        public Node rightNode;
        private int data;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", leftNode=" + leftNode +
                    ", rightNode=" + rightNode +
                    '}';
        }
    }

}
