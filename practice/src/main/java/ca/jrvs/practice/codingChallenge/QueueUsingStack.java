package ca.jrvs.practice.codingChallenge;

import java.util.Stack;

/**
 * pop: O(n) time complexity, since we iterate through the whole stack twice, we can ignore constants.
 */
public class QueueUsingStack {

  Stack<Integer> stack = new Stack<>();

  public QueueUsingStack() {
  }

  public void push(int x) {
    Stack<Integer> tempStack = new Stack<>();


    while (!stack.isEmpty()){
      int num = stack.pop();
      tempStack.push(num);
    }
    //push the number
    stack.push(x);

    while (!tempStack.isEmpty()){
      int num = tempStack.pop();
      stack.push(num);
    }

  }

  public int pop() {
    return stack.pop();
  }

  public int peek() {
    return stack.peek();
  }

  public boolean empty() {
    if (stack.isEmpty()){return true;}
    else {return false;}
  }
}
