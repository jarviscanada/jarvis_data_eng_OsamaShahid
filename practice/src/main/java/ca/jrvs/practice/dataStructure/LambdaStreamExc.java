package ca.jrvs.practice.dataStructure;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface LambdaStreamExc {

  /**
   * Create a String stream from array
   *
   * @param strings
   * @return
   */
  Stream<String> createStrStream(String ... strings);

  /**
   * Convert all strings to uppercase
   * please use createStrStream
   *
   * @param strings
   * @return
   */
  Stream<String> toUpperCase(String ... strings);


  /**
   * filter strings that contain the pattern
   * e.g.
   * filter(stringStream, "a") will return another stream which no element contain a
   *
   * @param stringStream
   * @param pattern
   * @return
   */
  Stream<String> filter(Stream<String> stringStream, String pattern);

  /**
   * Comvert a stream to list
   *
   * @param arr
   * @return
   */
  IntStream createIntStream(int[] arr);

  /**
   * Convert a intStream to list
   *
   * @param stream
   * @param <E>
   * @return
   */
  <E> List<E> toList(Stream<E> stream);

  /**
   * Convert a intStream to list
   * @param intStream
   * @return
   */
  List<Integer> toList(IntStream intStream);


  /**
   * Create a IntStream range from start to end inclusive
   * @param start
   * @param end
   * @return
   */
  IntStream createIntStream(int start, int end);


  /**
   * Conver a intStream to a doubleStream and
   * compute a square root of each element
   * @param intStream
   * @return
   */
  DoubleStream squareRootIntStream(IntStream intStream);

  /**
   * filter all even number sna return off number from intStream
   * @param intStream
   * @return
   */
  IntStream getOdd(IntStream intStream);


  /**
   * Retrun a lambda function that prints a message with a prefix and suffix
   * this lambda can be useful to format logs
   *
   * You will learn :
   *      - Functional interface
   *      - Lambda syntax
   *
   * @param prefix prefix str
   * @param suffix suffix str
   * @return
   */
  Consumer<String> getLambdaPrinter(String prefix, String suffix);


  /**
   * Print each message with a given printer
   * Please use 'getLambdaPrinter' method
   *
   * @param messages
   * @param printer
   */
  void printMessages(String[] messages, Consumer<String> printer);


  /**
   * Print all off number from a intStream
   * Please use 'createIntStream' and 'getLambdaPrinter' method
   *
   * @param intStream
   * @param printer
   */
  void printOdd(IntStream intStream, Consumer<String> printer);


  /**
   * Square each number from the inputs
   * Please write two solutions and compare differences
   *      - use flatMap
   *
   * @param ints
   * @return
   */
  Stream<Integer> flatNestedInt(Stream<List<Integer>> ints);

}
