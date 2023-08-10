package collectionsmaps;

import java.util.Objects;

public class FileData {
    private String fileName;
    private int sizeInBytes;
    private String pathToFile;

    public FileData(String fileName, int sizeInBytes, String pathToFile) {
        this.fileName = fileName;
        this.sizeInBytes = sizeInBytes;
        this.pathToFile = pathToFile;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public int getSizeInBytes() {
        return sizeInBytes;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileData fileData = (FileData) o;
        return sizeInBytes == fileData.sizeInBytes && Objects.equals(fileName, fileData.fileName) && Objects.equals(pathToFile, fileData.pathToFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, sizeInBytes, pathToFile);
    }
}
