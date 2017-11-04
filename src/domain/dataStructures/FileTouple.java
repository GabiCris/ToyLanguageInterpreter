package domain.dataStructures;

import java.io.BufferedReader;

public class FileTouple {
    private final String fileName;
    private final BufferedReader fileReader;

    public FileTouple(String fileName, BufferedReader fileReader) {
        this.fileName = fileName;
        this.fileReader = fileReader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileTouple that = (FileTouple) o;

        return fileName.equals(that.fileName);
    }

    public String getFileName() {
        return fileName;
    }

    public BufferedReader getFileReader() {
        return fileReader;
    }

    @Override
    public String toString() {
        return this.fileName;
    }
}
