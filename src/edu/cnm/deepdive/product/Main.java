package edu.cnm.deepdive.product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) throws IOException {
    Path path = Paths.get("largest-product-data.txt");
    Pattern pattern = Pattern.compile("\\s+");
    int[][] data = readIntMatrix(path, pattern);
  }

  private static int[][] readIntMatrix(Path source, Pattern delimiter) 
      throws IOException {
    try (Stream<String> stream = Files.lines(source)) {
      return stream
          .parallel()
          .map(String::trim)
          .map((line) -> delimiter.splitAsStream(line)
              .mapToInt(Integer::parseInt)
              .toArray())
          .toArray(int[][]::new);
    }
  }
  
}
























