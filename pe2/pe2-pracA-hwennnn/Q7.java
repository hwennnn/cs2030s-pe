import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Q7<T extends Fruit> 
  implements Comparator<FruitStall<? extends Fruit>> {
  @Override
  public int compare(FruitStall<?> first, 
      FruitStall<?> second) {
    int firstMin = first.getFruits().stream().min((x, y) -> 
        x.getDaysToExpiry() - y.getDaysToExpiry())
      .get().getDaysToExpiry();
    int secondMin = second.getFruits().stream().min((x, y) -> 
        x.getDaysToExpiry() - y.getDaysToExpiry())
      .get().getDaysToExpiry();

    return firstMin - secondMin;
  }
}
