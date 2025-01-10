package JavaDataStructuresAlgorithmsLEETCODEExercises.algoQuestions;

public class Recursion {

    public static void main(String[] args) {
        int factorial = factorial(4);
    }

    public static int factorial(int i) {
        if (i == 1) {
            return 1;
        }
        return i * factorial(i - 1);
    }



}
