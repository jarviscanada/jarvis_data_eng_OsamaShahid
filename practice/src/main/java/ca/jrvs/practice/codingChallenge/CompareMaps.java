package ca.jrvs.practice.codingChallenge;

import java.util.Map;

public class CompareMaps {



  public <K,V> boolean compareMaps(Map<K,V> m1, Map<K,V> m2){

    if (m1.isEmpty() && m2.isEmpty()){
      return true;
    }
    if (m1.isEmpty() || m2.isEmpty()){
      return false;
    }

    if (m1.equals(m2)){
      return true;
    }
    return false;
  }


}
