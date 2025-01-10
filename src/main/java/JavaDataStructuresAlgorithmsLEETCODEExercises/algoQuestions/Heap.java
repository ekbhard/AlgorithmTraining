package JavaDataStructuresAlgorithmsLEETCODEExercises.algoQuestions;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1,
                heap.get(index2));
        heap.set(index2,
                temp);
    }

    public void insert(int value) {
        heap.add(value);
        int currentIndex = heap.size() - 1;
        int tempParent = heap.get(parent(currentIndex));
        while (value > tempParent) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
            tempParent = heap.get(currentIndex);
        }
    }

    private Integer remove() {
        if (heap.size() == 0) {
            return null;
        }
        if (heap.size() == 1) {
            return heap.remove(0);
        }

        int maxValue = heap.get(0);

        heap.set(0, heap.remove(heap.size() - 1));

        sinkDown(0);

        return maxValue;

    }

    private void sinkDown(int index) {
        int maxIndex = index;
        while (true) {
            int leftIndex = leftChild(index);
            int rightIndex = leftChild(index);

            if (leftIndex < heap.size() && heap.get(leftIndex) > heap.get(index)) {
                maxIndex = leftIndex;
            }

            if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(index)) {
                maxIndex = rightIndex;
            }
            if (maxIndex != index) {
                swap(index, maxIndex);
                index = maxIndex;
            } else return;
        }
    }
}
