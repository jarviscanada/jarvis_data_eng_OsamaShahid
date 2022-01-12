package ca.jrvs.practice.codingChallenge;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

  /**
   * Using map approach we iterate over the string twice to we get O(2n), however we van remove constants so
   * final time complexity is O(n+m). Space complexity is O(n) since we used a map to store the character of string.
   * @param s
   * @param t
   * @return
   */
  public boolean isAnagram(String s, String t) {

    Map<Character, Integer> map = new HashMap<>();

    for (int i=0; i < s.length(); i++){
      char c = s.charAt(i); //get letter

      if (!map.containsKey(c)){
        map.put(c, 1);
      } else {
        map.put(c, map.getOrDefault(c, 0) + 1);
      }
    }

    for (int j =0; j < t.length(); j++){
      char c2 = t.charAt(j);

      if (!map.containsKey(c2)){
        return false; //not an anagram.
      } else {
        map.put(c2, map.getOrDefault(c2, 0) - 1);

        //Remove key if we get value ==0
        if (map.get(c2) == 0){
          map.remove(c2);
        }
      }
    }

    //if map is empty return true == anagram
    if (map.size() == 0){
      return true;
    } else {
      return false;
    }
  }


}
