import java.util.List;
import java.util.stream.Stream;

class Q6 {
  public static <T extends Fruit> List<FruitStall<Fruit>> consolidateStallsbyType(
      List<? extends FruitStall<? extends T>> fruits) {
    return fruits.stream()
      .flatMap(stall -> stall.getFruits().stream())
      .map(x -> x.getName())
      .distinct()
      .sorted()
      .map(name -> new FruitStall<Fruit>(
            fruits.stream()
            .flatMap(stall -> stall.getFruits().stream())
            .filter(x -> x.getName().equals(name)).toList()))
      .toList();
  }
}
