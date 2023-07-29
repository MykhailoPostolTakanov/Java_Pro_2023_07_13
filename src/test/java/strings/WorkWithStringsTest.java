package strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkWithStringsTest {

    @Test
    void findSymbolOccurance() {
        WorkWithStrings workWithStrings = new WorkWithStrings();
        int index = workWithStrings.findSymbolOccurance("Apple", 'l');
        assertEquals(3, index);
    }

    @Test
    void findWordPosition() {
        WorkWithStrings workWithStrings = new WorkWithStrings();
        int index = workWithStrings.findWordPosition("Test Mykhailo For Java", "Java");
        assertEquals(18, index);
    }

    @Test
    void stringReverse() {
        WorkWithStrings workWithStrings = new WorkWithStrings();
        String result = workWithStrings.stringReverse("Test Mykhailo For Java");
        assertEquals("avaJ roF oliahkyM tseT", result);
    }

    @Test
    void isPalindrome() {
        WorkWithStrings workWithStrings = new WorkWithStrings();
        boolean result = workWithStrings.isPalindrome("Jaj");
        assertEquals(true, result);
    }

    @Test
    void tryGuesWord() {
        WorkWithStrings workWithStrings = new WorkWithStrings();
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", " pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int result = workWithStrings.tryGuesWord(words, 13, "Kiwi");
        assertEquals(-1, result);
    }
    @Test
    void getPartOfWord(){
        WorkWithStrings workWithStrings = new WorkWithStrings();
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", " pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String result = workWithStrings.getPartOfWord(words, 13, 2);
        assertEquals("ki#############", result);
    }
}