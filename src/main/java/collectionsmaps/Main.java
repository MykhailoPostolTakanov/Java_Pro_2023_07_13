package collectionsmaps;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        FileData fileData1 = new FileData("test.txt", 555555555, "D:\\Repos");
        FileData fileData2 = new FileData("hello_word.java", 4444444, "D:\\Repos2");
        FileData fileData3 = new FileData("hello_word.java", 333333, "D:\\Repos");
        FileNavigator fileNavigator = new FileNavigator();
        Map<String, ArrayList<FileData>> resultAdd = new HashMap<String, ArrayList<FileData>>();
        resultAdd = fileNavigator.add("D:\\Repos", fileData1);
        System.out.println(resultAdd);
        resultAdd = fileNavigator.add("D:\\Repos2", fileData2);
        System.out.println(resultAdd);
        resultAdd = fileNavigator.add("D:\\Repos", fileData3);
        System.out.println(resultAdd);
        ArrayList<FileData> fileDataBySize = fileNavigator.filterBySize(4444444);
        System.out.println(fileDataBySize);
        ArrayList<FileData> deletedFiles = fileNavigator.remove("D:\\Repos");
        System.out.println(deletedFiles);
        resultAdd = fileNavigator.add("D:\\Repos", fileData1);
        resultAdd = fileNavigator.add("D:\\Repos", fileData3);
        ArrayList<FileData> sortedFiles = fileNavigator.sortBySize();
        System.out.println(sortedFiles);
        try {
            resultAdd = fileNavigator.add("D:\\Repos", fileData2);
        } catch (PathNotEquasException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
