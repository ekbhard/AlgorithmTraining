package JavaDataStructuresAlgorithmsLEETCODEExercises.dataStructures;

import java.util.HashSet;
import java.util.Set;

public class LinkedListWithoutTail {
    private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedListWithoutTail(int value) {
        Node newNode = new Node(value);
        head = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
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
        } else {
            System.out.println("Head: " + head.value);
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
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

    /*
    Функция partitionList принимает целое число x в качестве
    параметра и изменяет текущий связанный список на месте
    в соответствии с указанными критериями.
   Если связанный список пуст (т.е. head равен null), функция
   должна немедленно вернуться без внесения каких-либо изменений.

    Input:

    Linked List: 3 -> 8 -> 5 -> 10 -> 2 -> 1 x: 5

    Process:

    Values less than 5: 3, 2, 1

    Values greater than or equal to 5: 8, 5, 10

    Output:

    Linked List: 3 -> 2 -> 1 -> 8 -> 5 -> 10
     */

    public void partitionList(int k) {
        Node moreHead = null;
        Node lessHead = null;
        Node less = null;
        Node more = null;
        Node temp = head;

        for (int i = 0; i < length; i++) {
            if (temp == null) {
                return;
            }
            if (temp.value < k) {
                if (less == null) {
                    less = new Node(temp.value);
                    lessHead = less;
                } else {
                    less.next = new Node(temp.value);
                    less = less.next;
                }
            } else {
                if (more == null) {
                    more = new Node(temp.value);
                    moreHead = more;
                } else {
                    more.next = new Node(temp.value);
                }
            }
            temp = temp.next;
            more = more.next;
        }
        if (lessHead == null) {
            this.head = moreHead;
            return;
        }
        Node newOrderNode = lessHead;
        while (newOrderNode.next != null) {
            newOrderNode = newOrderNode.next;
        }
        newOrderNode.next = moreHead;
        this.head = lessHead;
    }
    /*
    функция которая должна удалить дупликаты из листа

     */

    public void removeDuplicates2() {
        Set<Integer> set = new HashSet<>();
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            if (set.contains(curr.value)) {
                prev.next = curr.next;
                length --;
            }
            else {
                set.add(curr.value);
                prev = curr;
            }

            curr = curr.next;
        }
    }
}
