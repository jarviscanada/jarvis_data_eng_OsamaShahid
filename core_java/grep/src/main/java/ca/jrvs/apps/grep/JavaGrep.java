package ca.jrvs.apps.grep;

import java.io.File;
import java.io.IOException;
import java.util.List;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public interface JavaGrep {

  /**
   * Top level search workflow
   * @throws IOException
   */
  void process() throws IOException;

  /**
   * Traverse a given directory and return all files
   * @param rootDir input directory
   * @return files under the rootDir
   */
  List<File> listFiles(String rootDir);


  /**
   * Read a file and return all the lines
   *
   * Explain FileReader, BufferedReader, and character encoding
   *
   * @param inputfile
   * @return
   * @throws IllegalArgumentException if a given inputFile is not a file
   */
  List<String> readLines(File inputFile);

  /**
   * check if a line contains the regex pattern (passed by user)
   * @param line input string
   * @return true if there is a match
   */
  boolean containsPattern(String line);

  /**
   * Writes to file
   * @param lines to be written
   * @throws IOException if given outfile is not a file
   */
  void writeToFile(List<String> lines) throws IOException;


  String getRootPath();
  void setRootPath(String rootPath);

  String getRegex();
  void setRegex(String regex);

  String getOutFile();
  void setOutFile(String outFile);

}




