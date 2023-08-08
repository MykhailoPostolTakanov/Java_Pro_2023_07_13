package phonebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhoneDirectory {
    private List<Record> records = new ArrayList<Record>();

    public PhoneDirectory(List<Record> records) {
        this.records.addAll(records);
    }

    protected List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public List<Record> add(Record record) {
        this.records.add(record);
        return records;
    }

    public Record find(String name) {
        for (Record record : this.records) {
            if (record.getName().equals(name)) {
                return new Record(record.getName(), Arrays.asList(record.getNumbers().get(0)));
            }
        }
        return null;
    }

    public List<Record> findAll(String name) {
        List<Record> findedRecords = new ArrayList<Record>();
        for (Record record : this.records) {
            if (record.getName().equals(name)) {
                findedRecords.add(record);
            }
        }
        if (findedRecords.size() == 0)
            return null;
        return findedRecords;
    }
}
