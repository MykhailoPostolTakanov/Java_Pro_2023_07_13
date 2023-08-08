package phonebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Record record1 = new Record("Misha", List.of(501111111, 502222222));
        Record record2 = new Record("Yura", List.of(503333333));
        Record record3 = new Record("Oleg", List.of(504444444, 505555555, 506666666));
        Record record4 = new Record("Ann", List.of(507777777));
        Record record5 = new Record("Misha", List.of(508888888));
        PhoneDirectory phoneDirectory = new PhoneDirectory(List.of(record1, record2, record3, record4, record5));
        Record findRes = phoneDirectory.find("Oleg");
        System.out.println(findRes.getName() + ": " + findRes.getNumbers());
        List<Record> findAllRes = phoneDirectory.findAll("Misha");
        for (Record rec : findAllRes)
            System.out.println(rec.getName() + ": " + rec.getNumbers());
    }
}
