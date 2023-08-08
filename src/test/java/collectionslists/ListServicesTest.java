package collectionslists;

import org.junit.jupiter.api.Test;
import strings.WorkWithStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListServicesTest {

    @Test
    void countOccurance() {
        String[] wordsArray = {"apple", "orange", "lemon", "banana", "banana", "lemon", "broccoli", "lemon", "orange",
                "garlic", "apple", "melon", "melon", "apple", "mango", "banana", "nut", "orange", "pea", "orange"};
        ListServices listServices = new ListServices();
        int count = listServices.countOccurance(Arrays.asList(wordsArray), "apple");
        assertEquals(3, count);
    }

    @Test
    void toList() {
        String[] wordsArray = {"apple", "orange", "lemon", "banana", "banana", "lemon", "broccoli", "lemon", "orange",
                "garlic", "apple", "melon", "melon", "apple", "mango", "banana", "nut", "orange", "pea", "orange"};
        ListServices listServices = new ListServices();
        List<String> wordsList = listServices.toList(wordsArray);
        assertEquals(Arrays.asList(wordsArray), wordsList);
    }

    @Test
    void findUnique() {
        Integer[] intArray = {1, 2, 3, 4, 4, 3, 5, 3, 2,
                6, 1, 7, 7, 1, 8, 4, 9, 2, 0, 2};
        Integer[] uniqInt = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        ListServices listServices = new ListServices();
        List<Integer> uniqIntByListServices = listServices.findUnique(Arrays.asList(intArray));
        assertEquals(uniqIntByListServices, Arrays.asList(uniqInt));
    }

    @Test
    void findUniqueString() {
        String[] wordsArray = {"apple", "orange", "lemon", "banana", "banana", "lemon", "broccoli", "lemon", "orange",
                "garlic", "apple", "melon", "melon", "apple", "mango", "banana", "nut", "orange", "pea", "orange"};
        String[] uniqWords = {"apple", "orange", "lemon", "banana", "broccoli", "garlic", "melon", "mango", "nut", "pea"};
        ListServices listServices = new ListServices();
        List<String> uniqWordsByListServices = listServices.findUniqueString(Arrays.asList(wordsArray));
        assertEquals(uniqWordsByListServices, Arrays.asList(uniqWords));
    }

    @Test
    void calcOccurance() {
        String[] wordsArray = {"apple", "orange", "lemon", "banana", "banana", "lemon", "broccoli", "lemon", "orange",
                "garlic", "apple", "melon", "melon", "apple", "mango", "banana", "nut", "orange", "pea", "orange"};
        List<String> expected = List.of("apple: 3","orange: 4","lemon: 3","banana: 3","broccoli: 1","garlic: 1","melon: 2","mango: 1","nut: 1","pea: 1");
        ListServices listServices = new ListServices();
        List<String> calcOccurance = listServices.calcOccurance(Arrays.asList(wordsArray));
        assertEquals(expected, calcOccurance);
    }

    @Test
    void findOccurance() {
        String[] wordsArray = {"apple", "orange", "lemon", "banana", "banana", "lemon", "broccoli", "lemon", "orange",
                "garlic", "apple", "melon", "melon", "apple", "mango", "banana", "nut", "orange", "pea", "orange"};
        List<Word> expected = List.of(
                new Word("apple", 3),
                new Word("orange", 4),
                new Word("lemon", 3),
                new Word("banana", 3),
                new Word("broccoli", 1),
                new Word("garlic", 1),
                new Word("melon", 2),
                new Word("mango", 1),
                new Word("nut", 1),
                new Word("pea", 1));
        //String expected = ": 3\n : 4\n : 3\n : 3\n : 1\n : 1\n melon: 2\n mango: 1\n nut: 1\n pea: 1\n";
        ListServices listServices = new ListServices();
        List<Word> findOccurance = listServices.findOccurance(Arrays.asList(wordsArray));
        assertEquals(expected, findOccurance);
    }
}