package ca.jrvs.practice.dataStructure;

public class RegexExcImp implements RegexExc {

  @Override
  public boolean matchJpeg(String filename) {
    String regexjpg = "jpg$";
    String regexjepg = "jpeg$";
    if (filename.matches(regexjepg) || filename.matches(regexjepg)){
      return true;
    } else{
      return false;
    }
  }
  @Override
  public boolean matchIp(String ip) {

    String regex = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$";

    if (ip.matches(regex)){
      return true;
    } else {
      return false;
    }
  }
  @Override
  public boolean isEmptyLine(String line) {
    String regex = "\\s+";
    if (line.matches(regex) || line.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }
}
