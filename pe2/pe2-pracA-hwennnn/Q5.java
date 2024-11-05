import java.util.List;
import java.util.stream.Stream;

public class Q5 {
  public static List<String> findUniqueFruitTypes(
      List<FruitStall<? extends Fruit>> fruits) {
    return fruits.stream()
      .flatMap(stall -> stall.getFruits().stream())
      .map(x -> x.getName())
      .distinct()
      .sorted()
      .toList();
  }
}
