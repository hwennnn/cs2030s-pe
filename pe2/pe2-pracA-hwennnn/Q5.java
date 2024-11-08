import java.util.List;
import java.util.stream.Stream;

public class Q5 {
  public static <T extends Fruit> List<String> findUniqueFruitTypes(
      List<? extends FruitStall<? extends T>> fruits) {
    return fruits.stream()
      .flatMap(stall -> stall.getFruits().stream())
      .map(x -> x.getName())
      .distinct()
      .sorted()
      .toList();
  }
}
