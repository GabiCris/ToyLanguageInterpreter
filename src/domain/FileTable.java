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
    public void put(FileTouple fileTouple) {
        fileTable.put(keyIndex, fileTouple);
        keyIndex++;
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
}
