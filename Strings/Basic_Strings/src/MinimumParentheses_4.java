/*

Link: https://www.youtube.com/watch?v=e7HyTdHAf4U

Problem Statement: Minimum Add to Make Valid Parentheses
Given a string "pattern", which contains only two types of characters ‘(’, ‘)’.
Your task is to find the minimum number of parentheses either ‘(’, ‘)’ we must add the parentheses in string ‘pattern’ and the resulted string is valid.
Condition for valid string-
Every opening parenthesis ‘(’ must have a correct closing parenthesis ‘)’.

 */

import java.util.Scanner;
import java.util.Stack;

public class MinimumParentheses_4 {

    public static int addMinimumParentheses(String str){

        // Creating Stack of Character type
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            // Opening bracket
            if (ch == '('){
                stack.push(ch);
            }
            // closing bracket
            else {
                if (stack.size() > 0 && stack.peek() == '('){  // Valid Parentheses
                    stack.pop();
                }else {
                    stack.push(ch);  // inValid Parentheses
                }
            }
        }
        return stack.size();
    }

    /**

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(addMinimumParentheses(str));
    }

     Input:
     (((((
     Output:
     5

     Input:
     ))(
     Output:
     3

     */

/*

Link: https://www.youtube.com/watch?v=Givpwgu9IIc&t=516s

Problem Statement: Minimum Remove to Make Valid Parentheses
Given a string s of '(' , ')' and lowercase English characters.
Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:
It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.

 */

    public static String removeMinimumParentheses(String str){   // removeMinimumParentheses is called reverseParentheses

        // Creating Stack of Integer type
        Stack<Integer> stack = new Stack<>();

        // Convert String into characterArray by using inbuilt function
        char ch[] = str.toCharArray();

        // Traversing characterArray
        for (int i = 0; i < ch.length; i++){

            // Opening bracket
            if (ch[i] == '('){
                stack.push(i);  // push index into stack
            }

            // closing bracket
            else if (ch[i] == ')'){
                if (stack.size() == 0){   // inValid Parentheses
                    ch[i] = '.';
                }else {
                    stack.pop();
                }
            }
        }

        // Remaining parentheses in stack is also invalid
        while (stack.size() > 0){
            ch[stack.pop()] = '.';
        }

        StringBuilder sb = new StringBuilder();
        for (char c : ch){
            if ( c != '.'){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(removeMinimumParentheses(str));
    }
}

/*
Input:
a)b(c)d
Output:
ab(c)d

Input:
lee(t(c)o)de)
Output:
lee(t(c)o)de

 */