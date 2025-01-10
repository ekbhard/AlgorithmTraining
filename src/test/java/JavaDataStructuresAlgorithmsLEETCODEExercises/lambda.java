package JavaDataStructuresAlgorithmsLEETCODEExercises;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class lambda {

    @Test
    public void dssd() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream().filter(o -> o % 2 == 0).collect(Collectors.toSet());

        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

        words.stream().filter(o -> o.length() > 5).collect(Collectors.toSet());

        List<String> list = words.stream().map(o -> o.toUpperCase()).sorted(String::compareTo).toList();


        List<List<Integer>> numbers2 = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );

        numbers2.stream().flatMap(Collection::stream).toList();

        numbers2.stream().map(list1 -> list1.stream().reduce(0, Integer::sum)).collect(Collectors.toSet());

        List<String> sentences = Arrays.asList("hello world", "java streams", "flat map example");

        List<String> list1 = sentences.stream().flatMap(string -> Arrays.stream(string.split(" "))).toList();

        List<String> numbers3 = Arrays.asList("1,2,3", "4,5", "6,7,8,9");

        numbers3.stream().flatMap(string -> Arrays.stream(string.split(","))).map(Integer::getInteger).toList();

        List<List<String>> data = Arrays.asList(
                Arrays.asList("a", "b", "c"),
                Arrays.asList("d", "e"),
                Arrays.asList("f", "g", "h")
        );

        String collect = data.stream().flatMap(Collection::stream).collect(Collectors.joining());


        List<String> phrases = Arrays.asList("java streams", "flatMap example", "senior developer");


        phrases.stream().flatMap(strn -> Arrays.stream(strn.split(" "))).map(o -> o.toUpperCase()).collect(Collectors.toSet());

        Map<Integer, List<String>> collect1 = phrases.stream().flatMap(o -> Arrays.stream(o.split(" "))).collect(Collectors.groupingBy(o -> o.length()));

        Map<Integer, Long> collect3 = phrases.stream().flatMap(o ->
                Arrays.stream(o.split(" "))).collect(Collectors.groupingBy(String::length, Collectors.counting()));
    }
}
