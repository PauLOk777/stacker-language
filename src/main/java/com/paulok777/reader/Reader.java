package com.paulok777.reader;

import com.paulok777.expander.Expander;

import java.util.List;
import java.util.stream.Collectors;

public class Reader {
    public static List<String> read(String path, Object port) {
        List<String> lines = FileReader.getLines(path);
        List<String> intermediateCode = lines.stream()
                .map(s -> Expander.HANDLE_FUNCTION_NAME + "(" + s + ")")
                .collect(Collectors.toList());
        intermediateCode.add(Expander.TERMINATE_FUNCTION_NAME + "()");
        return intermediateCode;
    }
}
