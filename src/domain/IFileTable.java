package domain;

import domain.dataStructures.FileTouple;

import java.io.BufferedReader;

public interface IFileTable {
    boolean isInTable(String fileName);
    void put(FileTouple fileTouple);
    FileTouple get(int key);
    public String toStringFile();
}
