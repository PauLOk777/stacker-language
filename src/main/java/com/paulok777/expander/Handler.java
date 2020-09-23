package com.paulok777.expander;

public class Handler {

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
                case "+" -> stack.push(second + first);
                case "-" -> stack.push(second - first);
                case "*" -> stack.push(second * first);
                case "/" -> stack.push(second / first);
                case "%" -> stack.push(second % first);
            }
        }
    }

    public static Object returnResult() {
        return stack.pop();
    }
}
