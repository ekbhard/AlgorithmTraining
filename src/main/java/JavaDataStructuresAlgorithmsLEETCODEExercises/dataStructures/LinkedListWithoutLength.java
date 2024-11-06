package JavaDataStructuresAlgorithmsLEETCODEExercises.dataStructures;

public class LinkedListWithoutLength {

    private Node head;
    private Node tail;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedListWithoutLength(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (head == null) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("\nLinked List:");
        if (head == null) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    //native - не оптимизированно, но работает
    public Node findMiddleNode() {
        int length = getLength();

        Node returnNode = head;
        int mid_index = length / 2;
        for (int i = 0; i < mid_index; i++) {
            returnNode = returnNode.next;
        }
        // temp will be storing middle element
        return returnNode;
    }

    private int getLength() {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }
    /*
    fast and slow pointers
    Перемещаем медленный указатель к следующему узлу (на один узел вперёд),
    а быстрый указатель — к следующему за ним узлу (на два узла вперёд).
    Когда быстрый указатель достигнет последнего узла или NULL,
     медленный указатель достигнет середины связанного списка.
     */

    public Node findMiddleNodeFastAndSlowPointers() {
        Node slowPointer = head;
        Node fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    /*
    реализовать алгоритм который делает проверку на has loop
     */
    public boolean hasLoop(){
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

    /*
    реализовать алгос который вернет к элемент с конца списка
     */

    public Node findKthFromEnd(int k) {
        Node fast = head;
        Node slow = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
