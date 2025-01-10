package JavaDataStructuresAlgorithmsLEETCODEExercises.dataStructures;

import org.junit.Test;

import java.util.List;

public class BinarySearchTreeTest {

    @Test
    public void binary_search_test() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(10);
        tree.insert(5);
        tree.insert(20);
        tree.insert(40);
        tree.insert(6);

        assert tree.contains(40);
        assert !tree.contains(45);
        assert tree.contains(10);
    }

    @Test
    public void recursive_insert(){
        BinarySearchTree tree = new BinarySearchTree();

        tree.rInsert(10);
        tree.rInsert(5);
        tree.rInsert(20);
        tree.rInsert(8);
        tree.rInsert(10);

    }

    @Test
    public void breadthFirstSearch(){
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(10);
        tree.insert(5);
        tree.insert(20);
        tree.insert(8);
        tree.insert(16);
        tree.insert(13);
        tree.insert(12);
        tree.insert(1);
        tree.insert(7);
        tree.insert(9);

        List<Integer> integers = tree.breadthFirstSearch();

        List<Integer> DFSInOrder = tree.DFSInOrder();

        Integer i = tree.kthSmallest(3);

        assert tree.isValidBST();

        System.out.println(integers);
        System.out.println(DFSInOrder);

    }
}
