package ca.jrvs.apps.grep;

import java.io.File;
import java.io.IOException;
import java.util.List;

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


    @Override
    public List<String> readLines(File inputFile) {

    }

    @Override
    public List<File> listFiles(String rootDir){

    }

    @Override
    public void writeToFile(List<String> lines) throws IOException {

    }


  }
}
