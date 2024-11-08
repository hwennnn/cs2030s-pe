import java.util.List;
import java.util.stream.Stream;

public class Q4 {
  public static <T extends Fruit> FruitStall<T> mergeStalls(FruitStall<? extends T> first, 
      FruitStall<? extends T> second) {
    return new FruitStall<>(
        Stream.concat(first.getFruits().stream(), second.getFruits().stream())
        .toList());
  }
}
