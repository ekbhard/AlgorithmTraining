package JavaDataStructuresAlgorithmsLEETCODEExercises.dataStructures;

public class BinarySearchTree {
    private Node root;

    class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (temp.value == newNode.value) {
                return false;
            }
            if (temp.value < newNode.value) {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                } else {
                    temp = temp.right;
                }
            } else {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                } else {
                    temp = temp.left;
                }
            }
        }
    }

    public boolean contains(int value) {
        Node temp = root;
        if (root == null) {
            return false;
        }
        if (root.value == value) {
            return true;
        }

        while (temp != null) {
            if (temp.value > value) {
                if (temp.left == null) {
                    return false;
                }
                if (temp.left.value == value) {
                    return true;
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right == null) {
                    return false;
                }
                if (temp.right.value == value) {
                    return true;
                } else {
                    temp = temp.right;
                }
            }
        }
        return false;
    }

}