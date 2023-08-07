package collectionslists;

import java.util.ArrayList;
import java.util.List;

public class ListServices {
    public int countOccurance(List<String> listString, String word) {
        int count = 0;
        for (String element : listString)
            if (element.equals(word))
                count++;
        return count;
    }

    public List<String> toList(String[] stringArray) {
        List<String> listString = new ArrayList<>();
        for (String el : stringArray)
            listString.add(el);
        return listString;
    }

    public List<Integer> findUnique(List<Integer> list) {
        List<Integer> unigList = new ArrayList<Integer>();
        for (int el : list)
            if (!unigList.contains(el))
                unigList.add(el);
        return unigList;
    }

    public List<String> findUniqueString(List<String> list) {
        List<String> unigList = new ArrayList<String>();
        for (String el : list)
            if (!unigList.contains(el))
                unigList.add(el);
        return unigList;
    }

    public String calcOccurance(List<String> list) {
        String string = "";
        List<String> uniqStringList = findUniqueString(list);
        for (String el : uniqStringList)
            string += el + ": " + countOccurance(list, el) + "\n";
        return string;
    }

    public List<Word> findOccurance(List<String> list) {
        List<Word> counterList = new ArrayList<Word>();
        List<String> uniqStringList = findUniqueString(list);
        for (String el : uniqStringList)
            counterList.add(new Word(el, countOccurance(list, el)));
        return counterList;
    }
}
