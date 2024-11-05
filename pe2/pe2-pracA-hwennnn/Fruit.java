public class Fruit {
  private Named nameFunc;
  private Perishable expiryFunc;

  public Fruit(Named nameFunc, Perishable expiryFunc) {
    this.nameFunc = nameFunc;
    this.expiryFunc = expiryFunc;
  }

  public String getName() {
    return this.nameFunc.getName();
  }

  public int getDaysToExpiry() {
    return this.expiryFunc.getDaysToExpiry();
  }

  @Override
  public String toString() {
    String s = String.format("%s (expires in %s days)",
        this.getName(), this.getDaysToExpiry());
    return s;
  }
}
