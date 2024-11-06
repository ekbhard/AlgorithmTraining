package JavaDataStructuresAlgorithmsLEETCODEExercises.dataStructures;

import org.junit.Test;

public class HashTableTest {

    @Test
    public void test_set_hashTable(){
        HashTable table = new HashTable();
        table.set("nails",100);
        table.set("tile",1000);
        table.set("lumber",1020);
    }
}
