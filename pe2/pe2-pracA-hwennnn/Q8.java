import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Q8 {
  public static List<FruitStall<? extends Fruit>> sortByShortestExpiry(
      List<FruitStall<? extends Fruit>> fruitStalls) {
    return fruitStalls.stream()
      .sorted((first, second) -> 
          first.getFruits().stream()
          .map(x -> x.getDaysToExpiry())
          .reduce(Integer.MAX_VALUE, (x, y) -> Math.min(x, y)) -
          second.getFruits().stream()
          .map(x -> x.getDaysToExpiry())
          .reduce(Integer.MAX_VALUE, (x, y) -> Math.min(x, y)))
      .toList();
  }
}
