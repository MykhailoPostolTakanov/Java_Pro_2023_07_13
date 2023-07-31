package strings;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WorkWithStrings workWithStrings = new WorkWithStrings();
        System.out.println(workWithStrings.findSymbolOccurance("Apple", 'p'));
        System.out.println(workWithStrings.findWordPosition("Test Mykhailo For Java", "Java"));
        System.out.println(workWithStrings.stringReverse("Test Mykhailo For Java"));
        System.out.println(workWithStrings.isPalindrome("Jaj"));
        //Task with star
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", " pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int wordIndex = getRandomNumber(0, 24);
        String displayedWord = "###############";
        System.out.println("Guess word " + displayedWord);
        Scanner scanner = new Scanner(System.in);
        boolean forLoop = true;
        while (forLoop) {
            String userword = scanner.nextLine();
            if (workWithStrings.wordСheck(words, wordIndex, userword)) {
                System.out.println("You GUESSED!!!");
                return;
            }
            displayedWord = workWithStrings.updateDisplayedWord(words, wordIndex, userword, displayedWord);
            if (displayedWord.contains(words[wordIndex])) {
                System.out.println("You LOST!!!");
                return;
            }
            System.out.println("Your answer is wrong");
            System.out.println(displayedWord + " - Hint");
        }
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
