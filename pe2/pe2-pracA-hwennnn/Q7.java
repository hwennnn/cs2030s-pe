import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Q7<T extends Fruit> 
    implements Comparator<FruitStall<? extends Fruit>> {
  @Override
  public int compare(FruitStall<? extends Fruit> first, 
      FruitStall<? extends Fruit> second) {
    int firstMin = first.getFruits().stream()
        .map(x -> x.getDaysToExpiry())
        .reduce(Integer.MAX_VALUE, (x, y) -> Math.min(x, y));
    int secondMin = second.getFruits().stream()
        .map(x -> x.getDaysToExpiry())
        .reduce(Integer.MAX_VALUE, (x, y) -> Math.min(x, y));

    return firstMin - secondMin;
  }
}
