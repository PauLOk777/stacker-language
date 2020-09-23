package com.paulok777.reader;

import java.util.List;
import java.util.stream.Collectors;

public class Reader {
    public static List<String> read(String path, Object port) {
        List<String> lines = FileReader.getLines(path);
        List<String> intermediateCode = lines.stream()
                .map(s -> "handle(" + s + ")")
                .collect(Collectors.toList());
        intermediateCode.add("terminate()");
        return intermediateCode;
    }
}
