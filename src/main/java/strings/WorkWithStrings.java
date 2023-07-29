package strings;

public class WorkWithStrings {
    private int showingLetters;

    public WorkWithStrings() {
        this.showingLetters = 0;
    }

    public int findSymbolOccurance(String line, char symbol) {
        int symbolindaex = -1;
        symbolindaex = line.indexOf(symbol);
        return symbolindaex;
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
        if (reverse.toUpperCase().equals(source.toUpperCase()))
            return true;
        else
            return false;
    }

    public int tryGuesWord(String[] words, int index, String word) {
        if (words[index].toUpperCase().equals(word.toUpperCase()))
            return -1;
        else {
            showingLetters++;
        }
        return showingLetters;
    }

    public String getPartOfWord(String[] words, int index,int showingLetters) {
        String partOfWord = "";
        for (var i = 0; i < showingLetters; i++) {
            partOfWord += words[index].charAt(i);
        }
        for (var i = showingLetters + 1; i <= 15; i++) {
            partOfWord += "#";
        }
        return partOfWord;
    }
}
