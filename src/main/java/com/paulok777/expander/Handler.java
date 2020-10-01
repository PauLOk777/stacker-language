package com.paulok777.expander;

//import javax.script.ScriptEngine;
//import javax.script.ScriptEngineManager;
//import javax.script.ScriptException;

public class Handler {

//    private static ScriptEngineManager manager = new ScriptEngineManager();
//    private static ScriptEngine engine = manager.getEngineByName("js");
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

            switch (intermediateLine) {
                case "+":
                    stack.push(second + first);
                    break;
                case "-":
                    stack.push(second - first);
                    break;
                case "*":
                    stack.push(second * first);
                    break;
                case "/":
                    if (first == 0) {
                        throw new ArithmeticException("Division by 0");
                    }
                    stack.push(second / first);
                    break;
            }
//            try {
//                stack.push((double) engine.eval(second + intermediateLine + first));
//            } catch (ScriptException e) {
//                e.printStackTrace();
//            }
        }
    }

    public static Object returnResult() {
        return stack.pop();
    }
}
