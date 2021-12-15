package ca.jrvs.apps.grep;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.security.auth.login.Configuration;

public class JavaGrepImp implements JavaGrep{

  final static Logger logger = LoggerFactory.getLogger(JavaGrepImp.class);

  private String regex;
  private String rootPath;
  private String outFile;


  @Override
  public void process() throws IOException {

    String rootDir = getRootPath();
    List<File> listFile = listFiles(rootDir);
    List<String> matchedLines = new ArrayList<>();

    for (File file : listFile){
      List<String> lines = readLines(file);

      for (String line : lines){
        if (containsPattern(line)){
          matchedLines.add(line);
        }
      }
    }

    writeToFile(matchedLines);
  }

  @Override
  public List<File> listFiles(String rootDir) {

    if (rootDir == null){
      return null;
    }

    File files = new File(rootDir);
    File[] listOfFiles = files.listFiles();
    List<File> listFiles = new ArrayList<>();

    for (File file : listOfFiles){
      if (!file.isDirectory()){
        listFiles.add(file);
      }
    }

    return listFiles;
  }

  @Override
  public List<String> readLines(File inputFile) {

    if (inputFile == null){
      return null;
    }

    List<String> linesList = new ArrayList<>();
    FileReader fw;
    BufferedReader br;

    try {
      fw = new FileReader(inputFile);
      br = new BufferedReader(fw);

      String line = br.readLine();

      while (line != null){
        linesList.add(line);
        line = br.readLine();
      }

      fw.close();
      br.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return linesList;
  }

  @Override
  public boolean containsPattern(String line) {

    if (line == null){
      return false;
    }

    String regex = getRegex();
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(line);

    if (matcher.matches()){
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void writeToFile(List<String> lines) throws IOException {

    if (lines == null){
      return;
    }

    String outfile = getOutFile();
    FileWriter writeOutFile;

    writeOutFile = new FileWriter(outfile);
    BufferedWriter bw = new BufferedWriter(writeOutFile);

    for (String line : lines){
      bw.write(line + "\n");
    }

    bw.close();
  }

  @Override
  public String getRegex() {
    return regex;
  }

  @Override
  public void setRegex(String regex) {
    this.regex = regex;
  }

  @Override
  public String getRootPath() {
    return rootPath;
  }

  @Override
  public void setRootPath(String rootPath) {
    this.rootPath = rootPath;
  }

  @Override
  public String getOutFile() {
    return outFile;
  }

  @Override
  public void setOutFile(String outFile) {
    this.outFile = outFile;
  }

  public static void main(String[] args) {
    if (args.length != 3){
      throw new IllegalArgumentException("USAGE: JavaGrep regex rootPath outFile");
    }



    JavaGrepImp grepImp = new JavaGrepImp();
    grepImp.setRegex(args[0]);
    grepImp.setRootPath(args[1]);
    grepImp.setOutFile(args[2]);

    try{
      grepImp.process();
    } catch (Exception e){
      JavaGrepImp.logger.error("Error: Unable to process", e);
    }
  }

}
