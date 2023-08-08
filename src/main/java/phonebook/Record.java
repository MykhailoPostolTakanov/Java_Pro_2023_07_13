package phonebook;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(name, record.name) && Objects.equals(numbers, record.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numbers);
    }

    @Override
    public String toString() {
        return "{" + name + ": " + numbers.toString() + "}";
    }
}
