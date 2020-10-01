package com.paulok777.expander;

import java.util.List;
import java.util.NoSuchElementException;

public class Expander {

    public static final String HANDLE_FUNCTION_NAME = "handle";
    public static final String TERMINATE_FUNCTION_NAME = "terminate";

    public static Object expand(List<String> intermediateCode) {
        for (int i = 0; i < intermediateCode.size() - 1; i++) {
            String line = intermediateCode.get(i);
            if (line.startsWith(HANDLE_FUNCTION_NAME)) {
                try {
                    Handler.handle(line.substring(HANDLE_FUNCTION_NAME.length() + 1, line.length() - 1));
                } catch (NoSuchElementException e) {
                    return "No such elements in stack.";
                }
            }
            if (line.startsWith(TERMINATE_FUNCTION_NAME)) {
                return Handler.returnResult();
            }
        }

        return null;
    }
}
