package JavaDataStructuresAlgorithmsLEETCODEExercises.dataStructures;

import org.junit.Test;

public class LinkedListWithoutLengthTest {

    @Test
    public void test_findMiddleNode_method1() {
        LinkedListWithoutLength myList1 = new LinkedListWithoutLength(1);
        myList1.append(2);
        myList1.append(3);
        myList1.append(4);
        myList1.append(5);
        LinkedListWithoutLength.Node middleNode1 = myList1.findMiddleNode();
        assert middleNode1 != null;
        assert middleNode1.value == 3;


    }

    @Test
    public void test_findMiddleNode_method2() {
        LinkedListWithoutLength myList2 = new LinkedListWithoutLength(1);
        myList2.append(2);
        myList2.append(3);
        myList2.append(4);
        myList2.append(5);
        myList2.append(6);
        LinkedListWithoutLength.Node middleNode2 = myList2.findMiddleNode();
        assert middleNode2 != null;
        assert middleNode2.value == 4;
    }

    @Test
    public void test_findMiddleNodeFastAndSlowPointers_method1() {
        LinkedListWithoutLength myList1 = new LinkedListWithoutLength(1);
        myList1.append(2);
        myList1.append(3);
        myList1.append(4);
        myList1.append(5);
        LinkedListWithoutLength.Node middleNode1 = myList1.findMiddleNodeFastAndSlowPointers();
        assert middleNode1 != null;
        assert middleNode1.value == 3;


    }

    @Test
    public void test_findMiddleNodeFastAndSlowPointers_method2() {
        LinkedListWithoutLength myList2 = new LinkedListWithoutLength(1);
        myList2.append(2);
        myList2.append(3);
        myList2.append(4);
        myList2.append(5);
        myList2.append(6);
        LinkedListWithoutLength.Node middleNode2 = myList2.findMiddleNodeFastAndSlowPointers();
        assert middleNode2 != null;
        assert middleNode2.value == 4;
    }


    @Test
    public void test_findKthFromEnd() {
        LinkedListWithoutLength myList2 = new LinkedListWithoutLength(1);
        myList2.append(2);
        myList2.append(3);
        myList2.append(4);
        myList2.append(5);
        myList2.append(6);
        LinkedListWithoutLength.Node node = myList2.findKthFromEnd(2);
        assert node != null;
        assert node.value == 5;
    }

    @Test
    public void test1_partitionList() {
        LinkedListWithoutTail myList = new LinkedListWithoutTail(3);
        myList.append(8);
        myList.append(5);
        myList.append(10);
        myList.append(2);
        myList.append(1);
        myList.partitionList(5);
        var node = myList.getHead();
        assert node.value == 3;
        assert node.next.value == 2;
        assert node.next.next.value == 1;
        assert node.next.next.next.value == 8;
        assert node.next.next.next.next.value == 5;
        assert node.next.next.next.next.next.value == 10;
    }

    @Test
    public void test2_partitionList() {
        LinkedListWithoutTail myList = new LinkedListWithoutTail(3);
        myList.append(8);
        myList.append(5);
        myList.append(10);
        myList.append(2);
        myList.append(1);
        myList.partitionList(5);
        var node = myList.getHead();
        assert node.value == 3;
        assert node.next.value == 2;
        assert node.next.next.value == 1;
        assert node.next.next.next.value == 8;
        assert node.next.next.next.next.value == 5;
        assert node.next.next.next.next.next.value == 10;
    }

    @Test
    public void  test_LinkedListWithoutTail(){
        LinkedListWithoutTail myList = new LinkedListWithoutTail(3);
        myList.append(8);
        myList.append(6);
        myList.append(6);
        myList.append(5);
        myList.append(3);
        myList.append(2);
        myList.append(7);
        myList.append(8);
        myList.removeDuplicates2();
        var nsf = myList.getHead();
    }

}
