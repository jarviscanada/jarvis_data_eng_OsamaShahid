package ca.jrvs.practice.codingChallenge;

import java.util.HashMap;
import java.util.Map;

public class FibanacciNumber {


  /**
   * Recursive Solution: time complexity O(2^n) because the recurisve tree grows exponentially.
   * Space complexity is O(n) because the the recurive stack holds at most n elements as it pops and add n elements.
   * @param n
   * @return
   */
  public int fib(int n) {

    if (n == 0){
      return 0;
    } else if ( n == 1 ){
      return 1;
    }

    return fib(n-1) + fib(n-2);
  }


  /**
   * The dynamic programming approach time complexity is O(n). Because we iterate through each n fib numbers.
   * Since height of tree is n, if the number is in table it takes O(1) to determine the value.
   * Space complexity in O(n): since we use a map to store n elements at max.
   * @param n
   * @return
   */
  public int fibDP(int n) {

    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    if (n == 0){
      return 0;
    } else if ( n == 1 ){
      return 1;
    }

    return dpHelper(n, memo);
  }

  public int dpHelper(int n, Map<Integer, Integer> memo){

    if (n == 0){
      return 0;
    } else if ( n == 1 ){
      return 1;
    }

    if (memo.containsKey(n)){
      return memo.get(n);
    } else {
      int val = dpHelper(n-1, memo) + dpHelper(n-2, memo);
      memo.put(n, val);
      return val;
    }

  }
}
