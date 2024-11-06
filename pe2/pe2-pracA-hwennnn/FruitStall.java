import java.util.List;

public class FruitStall<T extends Fruit> {
  private List<? extends Fruit> fruits;

  public FruitStall(List<? extends Fruit> fruits) {
    this.fruits = fruits;
  }

  public FruitStall() {
    this.fruits = List.of();
  }

  public List<? extends Fruit> getFruits() {
    return this.fruits.stream().toList();
  }

  public List<? extends Fruit> findFruitsByName(String name) {
    return this.fruits.stream()
      .filter(x -> x.getName().equals(name))
      .toList();
  }

  @Override
  public String toString() {
    return this.fruits.stream()
      .map(x -> "\n- " + x.toString())
      .reduce("", (id, t) -> id + t) + "\n";
  }
}
