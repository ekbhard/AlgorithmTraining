package JavaDataStructuresAlgorithmsLEETCODEExercises.dataStructures;


import org.junit.Test;

public class LinkedListTest {

    @Test
    public void test_get_method() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);

        var node = linkedList.get(2);
        assert (node.value == 3);

        var node2 = linkedList.get(4);
        assert (node2 == null);

        var node3 = linkedList.get(3);
        assert (node3.value == 4);
    }

    @Test
    public void test_set_method() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);

        var node = linkedList.get(2);
        assert (node.value == 3);

        var node2 = linkedList.get(4);
        assert (node2 == null);

        var node3 = linkedList.get(3);
        assert (node3.value == 4);
    }

    @Test
    public void test_reverse_method() {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);

        linkedList.reverse();

        String s = linkedList.printList();
        assert s.equals("4 3 2 1 ");
        assert linkedList.getHead().value == 4;
        assert linkedList.getTail().value == 1;
    }
}
