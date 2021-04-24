package com.leetcode.subject150;

import javax.jws.soap.SOAPBinding;
import java.util.Stack;

/**
 * @author Liu
 * @date 2021/2/15 12:41
 */
public class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    stack.push(stack.pop() + stack.pop());
                    break;
                }
                case "*": {
                    stack.push(stack.pop() * stack.pop());
                    break;
                }
                case "-": {
                    Integer right = stack.pop();
                    stack.push(stack.pop() - right);
                    break;
                }
                case "/": {
                    Integer right = stack.pop();
                    stack.push(stack.pop() / right);
                    break;
                }
                default: {
                    stack.push(Integer.parseInt(token));
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        Solution solution = new Solution();
        int result = solution.evalRPN(tokens);
        System.out.println(result);
    }
}
