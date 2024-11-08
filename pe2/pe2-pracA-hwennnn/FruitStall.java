import java.util.List;

public class FruitStall<T extends Fruit> {
  private List<T> fruits;

  public FruitStall(List<? extends Fruit> fruits) {
    /**
     * It is safe to cast `List<? extends Fruit>` to `List<T>` 
     * because `T` is guaranteed to be a subtype of `Fruit`, 
     * ensuring type safety at runtime.
     */
    @SuppressWarnings("unchecked")
    List<T> temp = (List<T>) fruits;
    this.fruits = temp;
  }

  public FruitStall() {
    this.fruits = List.of();
  }

  public List<T> getFruits() {
    return this.fruits.stream().toList();
  }

  public List<T> findFruitsByName(String name) {
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
