package strings;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WorkWithStrings workWithStrings = new WorkWithStrings();
        System.out.println(workWithStrings.findSymbolOccurance("Apple", 'A'));
        System.out.println(workWithStrings.findWordPosition("Test Mykhailo For Java", "Java"));
        System.out.println(workWithStrings.stringReverse("Test Mykhailo For Java"));
        System.out.println(workWithStrings.isPalindrome("Jaj"));
        //Task with star
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", " pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int wordIndex = getRandomNumber(0, 25);
        System.out.println("Guess word ###############");
        Scanner scanner = new Scanner(System.in);
        boolean forLoop = true;
        while (forLoop) {
            String userword = scanner.nextLine();
            int index = workWithStrings.tryGuesWord(words, wordIndex, userword);
            if (index == -1) {
                System.out.println("You GUESSED!!!");
                return;
            } else {
                if (index >= words[wordIndex].length()) {
                    System.out.println("You lose!");
                    return;
                }
                String partOfWord = workWithStrings.getPartOfWord(words, wordIndex, index);
                System.out.println("Your answer is wrong");
                System.out.println("Hint");
                System.out.println(partOfWord);
            }
        }
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
