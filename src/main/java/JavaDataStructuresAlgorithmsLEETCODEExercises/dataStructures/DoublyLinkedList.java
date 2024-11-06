package JavaDataStructuresAlgorithmsLEETCODEExercises.dataStructures;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
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

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
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
        System.out.println("\nDoubly Linked List:");
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

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            Node temp = tail;
            head = null;
            tail = null;
            length--;
            return temp;
        }
        Node curr = tail;
        tail = curr.prev;
        tail.next = null;
        length--;
        return curr;
    }

    public void prepend(int i) {
        Node newNode = new Node(i);
        if (length == 0) {
            tail = newNode;
            head = newNode;
            length++;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            length++;
        }
    }

    public Node removeFirst() {
        Node temp = head;
        if (length == 0) return null;
        if (length == 1) {
            head = null;
            tail = null;
            length--;
            return temp;
        } else {
            head = temp.next;
            head.prev = null;
            length--;
            return temp;

        }
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        if (index < length / 2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node before = get(index - 1);
        Node after = before.next;

        newNode.prev = before;
        newNode.next = after;

        before.next = newNode;
        after.prev = newNode;

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

        Node forRemove = get(index);
        forRemove.next.prev = forRemove.prev;
        forRemove.prev.next = forRemove.next;

        forRemove.prev = null;
        forRemove.next = null;

        length--;

        return forRemove;
    }

    public void swapFirstLast() {
        if (length < 2) return;

        int head = getHead().value;
        int tail = getTail().value;

        Node headNode = getHead();
        headNode.value = tail;

        Node tailNode = getTail();
        tailNode.value = head;
    }

    public void reverse() {
        if (length == 0) return;
        Node newHead = new Node(tail.value);
        Node temp = newHead;

        for (int i = length - 2; i > -1; i--) {
            int value = get(i).value;
            Node forSet = new Node(value);
            temp.next = forSet;
            forSet.prev = temp;
            temp = temp.next;
        }
        tail = temp;
        head = newHead;
    }

    public boolean isPalindrome() {
        Node fromHead = head;
        Node fromTail = tail;

        for (int i = 0; i < length / 2; i++) {
            if (fromHead.value == fromTail.value) {
                fromHead = fromHead.next;
                fromTail = fromTail.prev;
            } else {
                return false;
            }
        }
        return true;
    }

    public void swapPairs() {

        if (head == null || head.next == null) {
            return;
        }

        Node current = head;
        Node newHead = head.next;

        while (current != null && current.next != null) {
            Node before = current;
            Node temp = current.next;
            Node after = temp.next;

            temp.prev = before.prev;
            temp.next = before;

            //если это не первая итерация, то на надо заменить указатель у конца предыдущей пары
            if (before.prev != null) {
                before.prev.next = temp;
            }

            before.prev = temp;
            before.next = after;

            if (after != null) {
                after.prev = before;
            }
            current = after;
        }

        head = newHead;
    }
}
