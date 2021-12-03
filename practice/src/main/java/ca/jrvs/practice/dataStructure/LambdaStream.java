package ca.jrvs.practice.dataStructure;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaStream implements LambdaStreamExc{

  public static void main(String[] args) {

  }

  @Override
  public Stream<String> createStrStream(String... strings) {
    return Stream.of(strings);
  }

  @Override
  public Stream<String> toUpperCase(String... strings) {
    /*Stream.of(strings).map(x -> x.toUpperCase());*/
    return toUpperCase(strings);
  }

  @Override
  public Stream<String> filter(Stream<String> stringStream, String pattern) {
    return stringStream.filter( x -> x.matches(pattern));
  }

  @Override
  public IntStream createIntStream(int[] arr) {
    return Arrays.stream(arr);
  }

  @Override
  public <E> List<E> toList(Stream<E> stream) {
    return toList(stream);
  }

  @Override
  public List<Integer> toList(IntStream intStream) {
    return toList(intStream);
  }

  @Override
  public IntStream createIntStream(int start, int end) {
    return IntStream.range(start,end);
  }

  @Override
  public DoubleStream squareRootIntStream(IntStream intStream) {
    return squareRootIntStream(intStream);
  }


  @Override
  public IntStream getOdd(IntStream intStream) {
    return intStream.filter( x -> x%2!=0 );
  }

  @Override
  public Consumer<String> getLambdaPrinter(String prefix, String suffix) {
    return null;
  }

  @Override
  public void printMessages(String[] messages, Consumer<String> printer) {

  }

  @Override
  public void printOdd(IntStream intStream, Consumer<String> printer) {

  }

  @Override
  public Stream<Integer> flatNestedInt(Stream<List<Integer>> ints) {
    return null;
  }
}
