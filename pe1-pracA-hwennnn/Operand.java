/**
 * CS2030S PE1 Question 1
 * AY20/21 Semester 2
 *
 * @author A0308382A
 */

class Operand<T> {
  private final T value;

  public Operand(T value) {
    this.value = value;
  }

  public T eval() {
    return this.value;
  }
}
