package JavaDataStructuresAlgorithmsLEETCODEExercises.dataStructures;

/**
 * имплиментация связанного списка своими руками
 */
public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public String printList() {
        StringBuilder builder = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            builder.append(temp.value + " ");
            temp = temp.next;
        }
        return builder.toString();
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    /**
     * добавить элемент
     */
    public void append(int value) {
        Node node = new Node(value);
        if (length == 0) {
            this.tail = node;
            this.head = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        length++;
    }

    /**
     * удалить последнее и вернуть ноду
     */
    public Node removeLast() {
        Node pre = this.head;
        Node temp = this.head;

        if (length == 0) {
            return null;
        }

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        this.tail = pre;
        this.tail.next = null;
        length--;
        if (length == 0) {
            this.tail = null;
            this.head = null;
        }
        return temp;
    }

    /**
     * добавить в начале
     */
    public void prepend(int value) {
        Node node = new Node(value);
        if (length == 0) {
            this.head = node;
            this.tail = node;
            length++;
        } else {
            Node current = this.head;
            node.next = current;
            this.head = node;
            length++;
        }
    }

    /**
     * удалить сначала
     */
    public Node removeFirst() {
        if (length == 0) {
            return null;
        }
        Node temp = this.head;
        this.head = temp.next;
        temp.next = null;
        length--;
        if (length == 0) {
            this.tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (index >= length || index < 0) {
            return null;
        }
        if (index == 0) {
            return this.head;
        }
        if (index == length - 1) {
            return this.tail;
        }

        Node node = this.head;
        int i = 0;
        while (i < index) {
            node = node.next;
            i++;
        }
        return node;
    }

    public boolean set(int index, int value) {
        Node node = get(index);
        if (node == null) {
            return false;
        } else {
            node.value = value;
            return true;
        }
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        }
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length - 1) {
            append(value);
            return true;
        }
        Node previous = get(index - 1);
        if (previous == null) {
            return false;
        }
        Node newNode = new Node(value);
        newNode.next = previous.next;
        previous.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index > length) return null;

        if (index == 0) {
            return removeFirst();
        }

        if (index == length - 1) {
            return removeLast();
        }

        Node prevous = get(index - 1);
        Node removed = get(index);
        prevous.next = removed.next;
        length--;
        return removed;
    }

    //реверс линкедлиста

    public void reverse() {
        if (length == 0) {
            return;
        }
        if (length == 1) {
            return;
        }
        Node temp = this.head;
        head = tail;
        tail = temp;

        Node before = null;
        Node after;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
}
