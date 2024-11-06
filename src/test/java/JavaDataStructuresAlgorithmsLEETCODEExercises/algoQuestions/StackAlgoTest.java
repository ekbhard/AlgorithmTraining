package JavaDataStructuresAlgorithmsLEETCODEExercises.algoQuestions;

import JavaDataStructuresAlgorithmsLEETCODEExercises.dataStructures.MyQueue;
import org.junit.Test;

import java.util.Stack;

import static JavaDataStructuresAlgorithmsLEETCODEExercises.algoQuestions.StackAlgoQuestions.*;

public class StackAlgoTest {

    @Test
    public void test_sort_bt_stack(){
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(1);
        stack.push(5);
        stack.push(4);
        stack.push(9);
        stack.push(2);
        stack.push(8);

        Stack<Integer> integers = sortStack(stack);
    }

    @Test
    public void dequeue_test(){
        MyQueue queue = new MyQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
    }
    @Test
    public void test_reverse() {

        String myString = "hello";
        String reversedString = reverseString(myString);
        assert reversedString.equals("olleh");
    }

    @Test
    public void test_isBalancedParentheses() {

        testAndPrint("()",
                true);
        testAndPrint("()()",
                true);
        testAndPrint("(())",
                true);
        testAndPrint("()()()",
                true);
        testAndPrint("(()())",
                true);
        testAndPrint(")()(",
                false);
        testAndPrint(")(",
                false);
        testAndPrint("(()",
                false);
        testAndPrint("))",
                false);
        testAndPrint("(",
                false);
        testAndPrint(")",
                false);

    }

    public static void testAndPrint(String testStr, boolean expected) {
        // Run the test and store the result
        boolean result = isBalancedParentheses(testStr);

        // Print the test string, expected result, and actual result
        System.out.println("Test String: " + testStr);
        System.out.println("EXPECTED: " + expected);
        System.out.println("RESULT: " + result);

        // Check if the test passed or failed
        if (result == expected) {
            System.out.println("STATUS: PASS");
        } else {
            System.out.println("STATUS: FAIL");
        }

        // Print a separator for better readability
        System.out.println("--------------");
    }
}
