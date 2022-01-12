package ca.jrvs.practice.codingChallenge;

/**
 * For O(n) use KMP (Knuth-Morris-Pratt) Algo
 */
public class RotateString {

  public boolean rotateString(String s, String goal) {

      if (s.length() != goal.length()){
        return false;
      }
      int p1 = 0;
      int p2 = 0;
      char c1 = s.charAt(p1);
      char c2 = goal.charAt(p2);

      //Loop to make it c2 and c1 equal
      while (c2 != c1){
        p2++;

        if (p2 >= goal.length()){
          return false;
        }

        c2 = goal.charAt(p2); //change c2
      }
      while (p1 < s.length()){
        c1 = s.charAt(p1);
        c2 = goal.charAt(p2);

        if (c1 == c2){
          p1++;
          if (p2 >= goal.length()-1){
            p2 = 0; //start from beginning
          } else {
            p2++;
          }

        } else {
          return false;
        }

      }
      return true;
  }

  /**
   * Time Complexity: O(n^2). Since we iterate through the first list and add characters to back of list and compare each time
   * if it is equal to the goal. The comparasion also takes O(n). This is compared each time a letter is moved.
   * Space complexity is O(1).
   * @param s
   * @param goal
   * @return
   */
  public boolean rotateStringWorking(String s, String goal) {
    int count = 0;
    StringBuilder newString = new StringBuilder();
    newString.append(s); //append string

    while (count <= s.length()){

      char beginString = newString.charAt(0);

      if (newString.toString().compareTo(goal) == 0){
        return true;
      } else {
        newString.deleteCharAt(0);
        newString.append(beginString);
      }
      count++;
    }

    return false;
  }

}
