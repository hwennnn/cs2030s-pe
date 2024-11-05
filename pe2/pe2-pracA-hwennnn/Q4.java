import java.util.List;
import java.util.stream.Stream;

public class Q4 {
  public static FruitStall<Fruit> mergeStalls(FruitStall<? extends Fruit> first, 
      FruitStall<? extends Fruit> second) {
    List<? extends Fruit> mergedFruits = Stream.concat(first.getFruits().stream(), 
        second.getFruits().stream())
      .toList();

    return new FruitStall<>(mergedFruits);
  }
}
