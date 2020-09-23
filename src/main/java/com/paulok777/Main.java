package com.paulok777;

import com.paulok777.expander.Expander;
import com.paulok777.reader.Reader;

import java.util.List;

public class Main {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        args = new String[] {"example.stk", ""};
        if (args.length != 2) throw new IllegalArgumentException();
        if (args[0] == null || args[1] == null) throw new IllegalArgumentException();
        List<String> intermediateCode = Reader.read(args[0], args[1]);
        Object result = Expander.expand(intermediateCode);
        System.out.println(result);
    }
}
