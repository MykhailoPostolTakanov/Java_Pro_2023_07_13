package phonebook;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Record {
    private String name = "";
    private List<Integer> numbers = new ArrayList<Integer>();

    public Record(String name, List<Integer> numbers) {
        this.name = name;
        this.numbers = numbers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "{" + name + ": " + numbers.toString() + "}";
    }
}
