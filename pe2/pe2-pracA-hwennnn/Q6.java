import java.util.List;
import java.util.stream.Stream;

class Q6 {
  public static List<FruitStall<Fruit>> consolidateStallsbyType(
      List<FruitStall<? extends Fruit>> fruits) {
    List<? extends Fruit> flatten = fruits.stream()
        .flatMap(stall -> stall.getFruits().stream())
        .toList();

    List<String> fruitsNames = flatten.stream()
        .map(x -> x.getName())
        .distinct()
        .sorted()
        .toList();

    List<FruitStall<Fruit>> res = fruitsNames.stream()
        .map(name -> new FruitStall<Fruit>(
            flatten.stream()
            .filter(x -> x.getName().equals(name)).toList()))
        .toList();

    return res;
  }
}
