package JavaDataStructuresAlgorithmsLEETCODEExercises.dataStructures;

import org.junit.Test;

public class DoublyLinkedListTest {

    @Test
    public void test_removeLast() {
        DoublyLinkedList myList = new DoublyLinkedList(3);
        myList.append(8);
        myList.append(6);
        myList.removeLast();
    }

    @Test
    public void test_get() {
        DoublyLinkedList myList = new DoublyLinkedList(3);
        myList.append(8);
        myList.append(4);
        myList.append(7);
        myList.append(1);
        myList.append(5);
        myList.append(25);
        myList.append(9);
        myList.append(8);
        DoublyLinkedList.Node node1 = myList.get(3);
        assert node1.value == 4;

        DoublyLinkedList.Node node2 = myList.get(4);
        assert node2.value == 7;

        DoublyLinkedList.Node node3 = myList.get(5);
        assert node3.value == 1;

        DoublyLinkedList.Node node4 = myList.get(9);
        assert node4.value == 8;

    }

    @Test
    public void test_set() {
        DoublyLinkedList myList = new DoublyLinkedList(3);
        myList.append(8);
        myList.append(4);
        myList.append(7);

        myList.set(0,
                6);
    }

    @Test
    public void test_insert() {
        DoublyLinkedList myList = new DoublyLinkedList(3);
        myList.append(8);
        myList.append(4);
        myList.append(7);

        myList.insert(1,
                6);

        assert myList.getHead().next.value == 6;
    }

    @Test
    public void test_remove() {
        DoublyLinkedList myList = new DoublyLinkedList(3);
        myList.append(8);
        myList.append(4);
        myList.append(7);

        myList.remove(1);

        assert myList.getHead().next.value == 4;
    }

    @Test
    public void test_swap() {
        DoublyLinkedList myList = new DoublyLinkedList(3);
        myList.append(8);
        myList.append(4);
        myList.append(7);

        myList.reverse();
        assert myList.getHead().value == 7;
        assert myList.getHead().next.value == 4;
        assert myList.getHead().next.next.value == 8;
        assert myList.getHead().next.next.next.value == 3;
    }

    @Test
    public void test_isPalindrome() {

        DoublyLinkedList myList1 = new DoublyLinkedList(3);
        myList1.append(8);
        myList1.append(4);
        myList1.append(7);

        assert !myList1.isPalindrome();

        DoublyLinkedList myList5 = new DoublyLinkedList(3);
        myList5.append(8);
        myList5.append(4);
        myList5.append(3);

        assert !myList5.isPalindrome();

        DoublyLinkedList myList2 = new DoublyLinkedList(3);
        myList2.append(8);
        myList2.append(8);
        myList2.append(3);

        assert myList2.isPalindrome();

        DoublyLinkedList myList3 = new DoublyLinkedList(3);
        myList3.append(8);
        myList3.append(9);
        myList3.append(8);
        myList3.append(3);

        assert myList3.isPalindrome();

    }

    @Test
    public void swap_test() {
        DoublyLinkedList myList3 = new DoublyLinkedList(1);
        myList3.append(2);
        myList3.append(3);
        myList3.append(4);
        myList3.swapPairs();

        assert myList3.getHead().value == 2;
        assert myList3.getHead().next.value == 1;
        assert myList3.getHead().next.next.value == 4;
        assert myList3.getHead().next.next.next.value == 3;

    }

    @Test
    public void swap_test2() {
        DoublyLinkedList myList3 = new DoublyLinkedList(1);
        myList3.append(2);
        myList3.append(3);
        myList3.append(4);
        myList3.append(5);

        myList3.swapPairs();

        assert myList3.getHead().value == 2;
        assert myList3.getHead().next.value == 1;
        assert myList3.getHead().next.next.value == 4;
        assert myList3.getHead().next.next.next.value == 3;
        assert myList3.getHead().next.next.next.next.value == 5;

    }

}
