package JavaDataStructuresAlgorithmsLEETCODEExercises.dataStructures;

import org.junit.Test;

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
}
