package phonebook;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PhoneDirectoryTest {

    @Test
    void add() {
        PhoneDirectory phoneDirectory = new PhoneDirectory(List.of(new Record("Misha", List.of(501111111))));
        List<Record> newPhoneDirectory = phoneDirectory.add(new Record("Oleg", List.of(502222222)));
        List<Record> expectedPhoneDirectory = List.of(new Record("Misha", List.of(501111111)), new Record("Oleg", List.of(502222222)));
        assertEquals(expectedPhoneDirectory, newPhoneDirectory);
    }

    @Test
    void find() {
        Record record1 = new Record("Misha", Arrays.asList(501111111, 502222222));
        Record record2 = new Record("Yura", Arrays.asList(503333333));
        Record record3 = new Record("Oleg", Arrays.asList(504444444, 505555555, 506666666));
        Record record4 = new Record("Ann", Arrays.asList(507777777));
        Record record5 = new Record("Misha", Arrays.asList(508888888));
        PhoneDirectory phoneDirectory = new PhoneDirectory(Arrays.asList(record1, record2, record3, record4, record5));
        Record findRes = phoneDirectory.find("Oleg");
        Record expected = new Record("Oleg", List.of(504444444));
        assertEquals(expected, findRes);
    }

    @Test
    void findAll() {
        Record record1 = new Record("Misha", List.of(501111111, 502222222));
        Record record2 = new Record("Yura", List.of(503333333));
        Record record3 = new Record("Oleg", List.of(504444444, 505555555, 506666666));
        Record record4 = new Record("Ann", List.of(507777777));
        Record record5 = new Record("Misha", List.of(508888888));
        PhoneDirectory phoneDirectory = new PhoneDirectory(List.of(record1, record2, record3, record4, record5));
        List<Record> findAllRes = phoneDirectory.findAll("Misha");
        List<Record> expected = List.of(
                new Record("Misha", List.of(501111111, 502222222)),
                new Record("Misha", List.of(508888888)));
        assertEquals(expected, findAllRes);
    }
}