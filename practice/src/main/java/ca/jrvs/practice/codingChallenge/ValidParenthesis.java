package ca.jrvs.practice.codingChallenge;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ValidParenthesis {

  public boolean isValid(String s) {

    char open1 = '(';
    char open2 = '{';
    char open3 = '[';
    char close1 = ')';
    char close2 = '}';
    char close3 = ']';

    Stack<Character> stack = new Stack<>();


    for (int i = 0; i < s.length(); i++){
      char c = s.charAt(i);

      if (open1 == c || open2 == c || open3 == c){
        stack.push(c);
      }


      if (c == close1 || c == close2 || c == close3){

        if (stack.isEmpty()){
          return false;
        }


        if (stack.peek() == open1 && c == close1){
          stack.pop();
        } else if (stack.peek() == open2 && c == close2){
          stack.pop();
        } else if (stack.peek() == open3 && c == close3){
          stack.pop();
        } else {
          return false;
        }
      }

    }


    if (stack.isEmpty()){
      return true;
    }

    return false;
  }


}
