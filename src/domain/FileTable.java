package domain;

import domain.dataStructures.FileTouple;
import domain.dataStructures.MyDictionary;
import domain.dataStructures.MyIDictionary;

import java.io.BufferedReader;

public class FileTable implements IFileTable {
    private MyIDictionary<Integer, FileTouple> fileTable = new MyDictionary<>();
    private Integer keyIndex = 0;

    @Override
    public boolean isInTable(String fileName) {
        return fileTable.isValueInDictionary(new FileTouple(fileName, null));
    }

    @Override
    public Integer put(FileTouple fileTouple) {
        fileTable.put(keyIndex, fileTouple);
        return keyIndex++;
    }

    @Override
    public void deleteEntry(int key) {
        fileTable.deleteEntry(key);
    }

    @Override
    public FileTouple get(int key) {
        return fileTable.get(key);
    }

    @Override
    public String toString() {
        return fileTable.toString();
    }

    public String toStringFile() {
        return fileTable.toStringFile();
    }

    public MyIDictionary<Integer, FileTouple> getFileTable() {
        return fileTable;
    }
}
