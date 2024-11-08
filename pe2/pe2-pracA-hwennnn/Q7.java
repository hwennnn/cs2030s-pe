import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Q7<T extends Fruit> implements 
    Comparator<FruitStall<? extends T>> {
  @Override
  public int compare(FruitStall<? extends T> first, 
      FruitStall<? extends T> second) {
    return first.getFruits().stream()
      .map(x -> x.getDaysToExpiry())
      .reduce(Integer.MAX_VALUE, (x, y) -> Math.min(x, y)) - 
      second.getFruits().stream()
      .map(x -> x.getDaysToExpiry())
      .reduce(Integer.MAX_VALUE, (x, y) -> Math.min(x, y));
  }
}
