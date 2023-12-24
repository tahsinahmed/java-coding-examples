package com.java.coding.problem;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /.
 * Each operand may be an integer or another expression.
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "*" ,"3", "*"};
        System.out.println(evalRPN(tokens));
    }

    private static int evalRPN(String[] tokens) {
        String operator = "+-*/";
        Stack<String> stack = new Stack<>();
        for (String t: tokens) {
            if (!operator.contains(t))
                stack.push(t);
            else {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                switch (t) {
                    case "+":
                        stack.push(b+a + "");
                        break;
                    case "-":
                        stack.push(b-a +"");
                        break;
                    case "*":
                        stack.push(b*a + "");
                        break;
                    default:
                        stack.push(b/a+ "");
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
