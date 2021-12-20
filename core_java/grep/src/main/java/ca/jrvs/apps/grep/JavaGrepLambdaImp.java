package ca.jrvs.apps.grep;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaGrepLambdaImp extends JavaGrepImp {

  public static void main(String[] args) {
    if (args.length != 3){
      throw new IllegalArgumentException("USAGE: JavaLambdaGrep regex rootPath outFile");
    }

    JavaGrepLambdaImp javaGrepLambda = new JavaGrepLambdaImp();

    javaGrepLambda.setRegex(args[0]);
    javaGrepLambda.setRootPath(args[1]);
    javaGrepLambda.setOutFile(args[2]);

    try {
      javaGrepLambda.process();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  @Override
  public void process() throws IOException {

    String rootDir = getRootPath();
    List<File> listFiles = listFiles(rootDir);
    List<String> matchedLines = new ArrayList<>();


    listFiles.stream()
        .forEach(
            file -> readLines(file)
            .stream()
            .filter( line -> containsPattern(line))
            .collect(Collectors.toCollection( () -> matchedLines ))
        );

    writeToFile(matchedLines);
  }


  @Override
  public List<File> listFiles(String rootDir){

    if ( rootDir == null ){
      return null;
    }

    File file = new File(rootDir);
    File[] files = file.listFiles();
    List<File> listOfFiles = new ArrayList<>();

    Arrays.stream(files).filter( x-> !x.isDirectory()).collect(Collectors.toCollection( () -> listOfFiles));

    return listOfFiles;
  }

  @Override
  public void writeToFile(List<String> lines) throws IOException {

    String outfile = getOutFile();
    FileWriter fw = new FileWriter(outfile);
    BufferedWriter bw = new BufferedWriter(fw);

    lines.stream().forEach(line -> {
      try {
        bw.write(line + "\n");
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
    bw.close();
  }

}