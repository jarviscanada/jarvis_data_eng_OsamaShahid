package ca.jrvs.practice.codingChallenge;

import java.util.LinkedList;
import java.util.Queue;


public class ImpStack {

  Queue<Integer> queue = new LinkedList<>();

  public ImpStack() {
  }

  public void push(int x) {
    Queue<Integer> tempQueue = new LinkedList<>();

    tempQueue.add(x);
    while (!queue.isEmpty()){
      tempQueue.add(queue.remove());
    }
    queue = tempQueue;
  }

  public int pop() {
    return queue.remove();
  }

  public int top() {
    return queue.peek();
  }

  public boolean empty() {
    if (queue.isEmpty()){
      return true;
    } else {
      return false;
    }

  }

}
