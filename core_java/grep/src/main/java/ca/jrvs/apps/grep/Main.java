package ca.jrvs.apps.grep;


public class Main {

  public static void main(String[] args) throws Exception {

    if (args.length != 3){
      throw new Exception("Need 3 arguments");
    }

    //Capture the arguments given
    String regexPattern = args[0];
    String filename = args[1];
    String outputFile = args[2];

    //Create new Grep Instance
    Grep eGrep = new Grep();

    //Call the function
    eGrep.grepFile(regexPattern, filename, outputFile);
  }
}
