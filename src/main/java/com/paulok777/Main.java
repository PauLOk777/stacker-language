package com.paulok777;

import com.paulok777.reader.Reader;

public class Main {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        args = new String[] {"example.stk", ""};
        if (args.length != 2) throw new IllegalArgumentException();
        if (args[0] == null || args[1] == null) throw new IllegalArgumentException();
        System.out.println(new Reader().read(args[0]));
    }
}
