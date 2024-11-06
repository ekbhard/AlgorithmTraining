package JavaDataStructuresAlgorithmsLEETCODEExercises.algoQuestions;

import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

import static JavaDataStructuresAlgorithmsLEETCODEExercises.algoQuestions.MapAlgoQuestions.*;

public class MapAlgoQuestionsTest {

    @Test
    public void test_findFirstNonRepeating() {
        var resul1 = MapAlgoQuestions.firstNonRepeatingChar("hello");
        assert Objects.requireNonNull(resul1).equals('h');
        var resul2 = MapAlgoQuestions.firstNonRepeatingChar("333!fFFF");
        assert Objects.requireNonNull(resul2).equals('!');
    }

    @Test
    public void testListOfAnagrams(){
        System.out.println("1st set:");
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println("\n2nd set:");
        System.out.println(groupAnagrams(new String[]{"abc", "cba", "bac", "foo", "bar"}));

        System.out.println("\n3rd set:");
        System.out.println(groupAnagrams(new String[]{"listen", "silent", "triangle", "integral", "garden", "ranged"}));
    }

    @Test
    public void test_twoSum(){
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        assert Arrays.equals(twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0,1});
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 10)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
        System.out.println(Arrays.toString(twoSum(new int[]{}, 0)));
    }

    @Test
    public void test_subAray(){
        var result = subarraySum(new int[]{1, 2, 3, 4, 5},9);
        assert result[0] == 1;
        assert result[2] == 3;
    }


}
