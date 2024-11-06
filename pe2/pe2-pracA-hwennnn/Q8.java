import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Q8 {
  public static List<FruitStall<? extends Fruit>> sortByShortestExpiry(
      List<FruitStall<? extends Fruit>> fruitStalls) {
    Comparator<FruitStall<? extends Fruit>> cmp = new Comparator<>() {
      @Override
      public int compare(FruitStall<? extends Fruit> first, 
          FruitStall<? extends Fruit> second) {
        int firstMin = first.getFruits().stream()
          .map(x -> x.getDaysToExpiry())
          .reduce(Integer.MAX_VALUE, (x, y) -> Math.min(x,y));
        int secondMin = second.getFruits().stream()
          .map(x -> x.getDaysToExpiry())
          .reduce(Integer.MAX_VALUE, (x, y) -> Math.min(x,y));

        return firstMin - secondMin;
      }
    };

    return fruitStalls.stream().sorted(cmp).toList();
      }
}
