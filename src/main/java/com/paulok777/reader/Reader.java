package com.paulok777.reader;

import java.util.List;
import java.util.stream.Collectors;

public class Reader {
    public static List<String> read(String path) {
        List<String> lines = FileReader.getLines(path);
        return lines.stream()
                .map(s -> "handle(" + s + ")")
                .collect(Collectors.toList());
    }
}
