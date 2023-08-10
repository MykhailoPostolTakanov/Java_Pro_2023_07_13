package collectionsmaps;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FileNavigatorTest {

    @Test
    void add() {
        FileData fileData1 = new FileData("test.txt", 555555555, "D:\\Repos");
        FileData fileData2 = new FileData("hello_word.java", 4444444, "D:\\Repos2");
        FileData fileData3 = new FileData("hello_word.java", 333333, "D:\\Repos");
        FileNavigator fileNavigator = new FileNavigator();
        Map<String, ArrayList<FileData>> resultAdd = new HashMap<String, ArrayList<FileData>>();
        fileNavigator.add("D:\\Repos", fileData1);
        fileNavigator.add("D:\\Repos2", fileData2);
        resultAdd = fileNavigator.add("D:\\Repos", fileData3);
        Map<String, ArrayList<FileData>> expected = new HashMap<String, ArrayList<FileData>>();
        ArrayList<FileData> arrFileData1 = new ArrayList<FileData>();
        arrFileData1.add(fileData1);
        arrFileData1.add(fileData3);
        ArrayList<FileData> arrFileData2 = new ArrayList<FileData>();
        arrFileData2.add(fileData2);
        expected.put("D:\\Repos", arrFileData1);
        expected.put("D:\\Repos2", arrFileData2);
        assertEquals(expected, resultAdd);
    }

    @Test
    void find() {
        FileData fileData1 = new FileData("test.txt", 555555555, "D:\\Repos");
        FileData fileData2 = new FileData("hello_word.java", 4444444, "D:\\Repos2");
        FileData fileData3 = new FileData("hello_word.java", 333333, "D:\\Repos");
        FileNavigator fileNavigator = new FileNavigator();
        fileNavigator.add("D:\\Repos", fileData1);
        fileNavigator.add("D:\\Repos2", fileData2);
        fileNavigator.add("D:\\Repos", fileData3);
        ArrayList<FileData> findedFileData = fileNavigator.find("D:\\Repos");
        ArrayList<FileData> expected = new ArrayList<FileData>();
        expected.add(fileData1);
        expected.add(fileData3);
        assertEquals(expected, findedFileData);
    }

    @Test
    void filterBySize() {
        FileData fileData1 = new FileData("test.txt", 555555555, "D:\\Repos");
        FileData fileData2 = new FileData("hello_word.java", 4444444, "D:\\Repos2");
        FileData fileData3 = new FileData("hello_word.java", 333333, "D:\\Repos");
        FileNavigator fileNavigator = new FileNavigator();
        fileNavigator.add("D:\\Repos", fileData1);
        fileNavigator.add("D:\\Repos2", fileData2);
        fileNavigator.add("D:\\Repos", fileData3);
        ArrayList<FileData> filesDataBySize = fileNavigator.filterBySize(4444444);
        ArrayList<FileData> expected = new ArrayList<FileData>();
        expected.add(fileData3);
        expected.add(fileData2);
        assertEquals(expected, filesDataBySize);
    }

    @Test
    void remove() {
        FileData fileData1 = new FileData("test.txt", 555555555, "D:\\Repos");
        FileData fileData2 = new FileData("hello_word.java", 4444444, "D:\\Repos2");
        FileData fileData3 = new FileData("hello_word.java", 333333, "D:\\Repos");
        FileNavigator fileNavigator = new FileNavigator();
        fileNavigator.add("D:\\Repos", fileData1);
        fileNavigator.add("D:\\Repos2", fileData2);
        fileNavigator.add("D:\\Repos", fileData3);
        ArrayList<FileData> deletedFiles = fileNavigator.remove("D:\\Repos");
        ArrayList<FileData> expected = new ArrayList<FileData>();
        expected.add(fileData1);
        expected.add(fileData3);
        assertEquals(expected, deletedFiles);
    }

    @Test
    void sortBySize() {
        FileData fileData1 = new FileData("test.txt", 555555555, "D:\\Repos");
        FileData fileData2 = new FileData("hello_word.java", 4444444, "D:\\Repos2");
        FileData fileData3 = new FileData("hello_word.java", 333333, "D:\\Repos");
        FileNavigator fileNavigator = new FileNavigator();
        fileNavigator.add("D:\\Repos", fileData1);
        fileNavigator.add("D:\\Repos2", fileData2);
        fileNavigator.add("D:\\Repos", fileData3);
        ArrayList<FileData> sortedFiles = fileNavigator.sortBySize();
        ArrayList<FileData> expected = new ArrayList<FileData>();
        expected.add(fileData3);
        expected.add(fileData2);
        expected.add(fileData1);
        assertEquals(expected, sortedFiles);
    }
}