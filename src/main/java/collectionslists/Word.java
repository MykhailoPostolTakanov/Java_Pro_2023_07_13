package collectionslists;

import java.util.Objects;

public class Word {
    private final String word;
    private int count;

    public Word(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return count == word1.count && Objects.equals(word, word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, count);
    }

    @Override
    public String toString() {
        return "{" + word + ": " + count + "}";
    }
}
