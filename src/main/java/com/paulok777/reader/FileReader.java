package com.paulok777.reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public static List<String> getLines(String path) {
        try(FileInputStream fis = new FileInputStream(path);
                Scanner scanner = new Scanner(fis)) {
            List<String> lines = new ArrayList<>();
            while(scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            return lines;
        } catch (IOException e) {
            e.getCause();
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }
}
