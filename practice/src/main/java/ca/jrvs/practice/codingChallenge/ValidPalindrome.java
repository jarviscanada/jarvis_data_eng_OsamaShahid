package ca.jrvs.practice.codingChallenge;

public class ValidPalindrome {

  /**
   * Time Complexity: O(n), since we use two pointers and iterate through the list once
   * Space Complexity: O(1), as we do not use additional data structures.
   * @param s
   * @return
   */
  public boolean isPalindrome(String s) {
    int p1 = 0;
    int p2 = s.length() - 1;

    char c1 = s.charAt(p1);
    char c2 = s.charAt(p2);

    if (Character.toLowerCase(c1) != Character.toLowerCase(c2)){
      return false;
    }

    while (p1 < p2){
      c1 = s.charAt(p1);
      c2 = s.charAt(p2);

      if (!Character.isLetter(c1)){
        p1++;
        continue;
      }
      if (!Character.isLetter(c2)){
        p2--;
        continue;
      }

      c1 = Character.toLowerCase(c1);
      c2 = Character.toLowerCase(c2);

      if ( c1 != c2 ){
        return false;
      } else {
        p1++;
        p2--;
      }
    }
    return true;
  }


  public boolean isPalindromeRec(String s) {


    return false;
  }


}
