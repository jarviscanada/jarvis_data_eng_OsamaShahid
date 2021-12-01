package ca.jrvs.apps.grep;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grep {

  /**
   * Return the string of characters that match
   * @param regex_pattern : Regex given
   * @param filename : the filename to open and read
   * @param outputFile : the outputfile to write the lines to
   */
  public void grepFile(String regex_pattern, String filename, String outputFile){
    // Checks to see if empty/null
    if (filename.isEmpty() || regex_pattern.isEmpty()){
      return;
    }
    //Initialize file reader
    FileReader file;
    FileWriter fileout;

    try {
      file = new FileReader(filename);
      fileout = new FileWriter(outputFile);
      BufferedReader bf = new BufferedReader(file);
      BufferedWriter bw = new BufferedWriter(fileout);
      String line = bf.readLine();

      //while the line is not null
      while (line != null){

        //Matches pattern given regex
        Pattern pattern = Pattern.compile(regex_pattern);
        Matcher matcher = pattern.matcher(line);

        //if match is found
        if (matcher.matches()){
          bw.write(line + "\n");
          System.out.println(line);
        }

        //Move onto next line
        line = bf.readLine();
      }

      //Close files
      bw.close();
      bf.close();

    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
