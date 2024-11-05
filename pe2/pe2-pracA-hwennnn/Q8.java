import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Q8 {
  public static List<FruitStall<? extends Fruit>> sortByShortestExpiry(
      List<FruitStall<? extends Fruit>> fruitStalls) {
    Comparator<FruitStall<? extends Fruit>> cmp = new Comparator<>() {
      @Override
      public int compare(FruitStall<?> first, FruitStall<?> second) {
        return first.getFruits().stream()
          .min((x, y) -> x.getDaysToExpiry() - y.getDaysToExpiry())
          .get().getDaysToExpiry() - 
          second.getFruits().stream()
          .min((x, y) -> x.getDaysToExpiry() - y.getDaysToExpiry())
          .get().getDaysToExpiry();
      }
    };

    return fruitStalls.stream().sorted(cmp).toList();
      }
}
