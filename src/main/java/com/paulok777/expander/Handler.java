package com.paulok777.expander;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Handler {

    @SuppressWarnings("removal")
    private static ScriptEngineManager manager = new ScriptEngineManager();
    private static ScriptEngine engine = manager.getEngineByName("js");
    private static Stack<Double> stack = new Stack<>();
    private final static String NUM_REGEX = "[-0-9]+";
    private final static String OPERATORS_REGEX = "[-+*%/]";

    public static void handle(String intermediateLine) {
        if (intermediateLine.matches(NUM_REGEX)) {
            stack.push(Double.valueOf(intermediateLine));
        }

        if (intermediateLine.matches(OPERATORS_REGEX)) {
            double first = stack.pop();
            double second = stack.pop();

            try {
                stack.push((double) engine.eval(second + intermediateLine + first));
            } catch (ScriptException e) {
               e.printStackTrace();
            }
        }
    }

    public static Object returnResult() {
        return stack.pop();
    }
}
