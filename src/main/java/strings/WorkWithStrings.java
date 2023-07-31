package strings;

public class WorkWithStrings {
    private int showingLetters;

    public WorkWithStrings() {
        this.showingLetters = 0;
    }

    public int findSymbolOccurance(String line, char symbol) {
        int count = 0;
        for (var i = 0; i < line.length(); i++)
            if (line.charAt(i) == symbol)
                count++;
        return count;
    }

    public int findWordPosition(String source, String target) {
        int firstIndex = -1;
        if (source.contains(target))
            firstIndex = source.indexOf(target.charAt(0));
        return firstIndex;
    }

    public String stringReverse(String source) {
        String reverse = "";
        for (var i = source.length() - 1; i > -1; i--)
            reverse += source.charAt(i);
        return reverse;
    }

    public boolean isPalindrome(String source) {
        String reverse = stringReverse(source);
        return reverse.toUpperCase().equals(source.toUpperCase());
    }

    public boolean wordСheck(String[] words, int index, String word) {
        return words[index].toUpperCase().equals(word.toUpperCase());
    }

    public String updateDisplayedWord(String[] words, int index, String word, String displayedWord) {
        for (var i = 0; i < word.length(); i++)
            if (i < words[index].length())
                if (words[index].charAt(i) == word.charAt(i))
                    displayedWord = displayedWord.substring(0, i) + words[index].charAt(i) + displayedWord.substring(i + 1);
        return displayedWord;
    }
}
