package collectionsmaps;

import java.util.*;

public class FileNavigator {
    private HashMap<String, ArrayList<FileData>> files = new HashMap<String, ArrayList<FileData>>();

    public HashMap<String, ArrayList<FileData>> add(String path, FileData fileData) {
        if (!path.equals(fileData.getPathToFile()))
            throw new PathNotEquasException("Має бути помилка, оскільки шлях-ключ і шлях до файлу не співпадають.\n" +
                    "Шлях: " + path + "\n" +
                    "FileData: {name: " + fileData.getFileName() + ", size: " + fileData.getSizeInBytes() + ", path: " + fileData.getPathToFile() + "}");
        if (files.containsKey(path)) {
            ArrayList<FileData> oldFiles = files.get(path);
            oldFiles.add(fileData);
            files.put(path, oldFiles);
        } else {
            ArrayList<FileData> fileDatas = new ArrayList<FileData>();
            fileDatas.add(fileData);
            files.put(path, fileDatas);
        }
        return files;
    }

    public ArrayList<FileData> find(String path) {
        if (files.containsKey(path))
            return files.get(path);
        else
            return new ArrayList<FileData>();
    }

    public ArrayList<FileData> filterBySize(int sizeInBytes) {
        ArrayList<FileData> filteredFilesBySize = new ArrayList<FileData>();
        for (String key : files.keySet())
            for (FileData fileData : files.get(key))
                if (fileData.getSizeInBytes() <= sizeInBytes)
                    filteredFilesBySize.add(fileData);
        return filteredFilesBySize;
    }

    public ArrayList<FileData> remove(String path) {
        ArrayList<FileData> deletedFiles = new ArrayList<FileData>();
        for (FileData file : files.get(path)) {
            deletedFiles.add(file);
        }
        files.remove(path);
        return deletedFiles;
    }

    public ArrayList<FileData> sortBySize() {
        ArrayList<FileData> sortedfiles = new ArrayList<FileData>();
        FileData[] filesForSorting = {};
        for (String key : files.keySet())
            for (FileData fileData : files.get(key))
                sortedfiles.add(fileData);
        sortedfiles.sort(Comparator.comparingInt(FileData::getSizeInBytes));
        return sortedfiles;
    }

}
