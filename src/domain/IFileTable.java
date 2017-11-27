package domain;

import domain.dataStructures.FileTouple;
import domain.dataStructures.MyIDictionary;

import java.io.BufferedReader;

public interface IFileTable {
    boolean isInTable(String fileName);
    Integer put(FileTouple fileTouple);
    FileTouple get(int key);
    void deleteEntry(int key);
    public String toStringFile();
    public MyIDictionary<Integer, FileTouple> getFileTable();
}
