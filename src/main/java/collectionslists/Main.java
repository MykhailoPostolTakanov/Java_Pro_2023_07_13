package collectionslists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ListServices listServices = new ListServices();
        String[] wordsArray = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut"};
        List<String> listString = new ArrayList<>();
        int wordIndex = getRandomNumber(0, 10);
        String word = wordsArray[wordIndex];
        for (var i = 0; i < 20; i++) {
            listString.add(wordsArray[getRandomNumber(0, 10)]);
        }
        int count = listServices.countOccurance(listString, word);
        System.out.println(count);
        List<String> listStringFromArray = listServices.toList(wordsArray);
        System.out.println(listStringFromArray);
        List<Integer> intList = new ArrayList<>();
        for (var i = 0; i < 20; i++)
            intList.add(getRandomNumber(0, 7));
        System.out.println(intList);
        List<Integer> uniqIntList = listServices.findUnique(intList);
        System.out.println(uniqIntList);
        System.out.println(listString);
        System.out.println(listServices.calcOccurance(listString));
        List<Word> counterList = listServices.findOccurance(listString);
        for (Word counter : counterList)
            System.out.print(counter.getWord() + " - " + counter.getCount() + "; ");
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
