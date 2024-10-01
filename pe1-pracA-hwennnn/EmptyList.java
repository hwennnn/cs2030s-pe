/**
 * CS2030S PE1 Question 2
 * AY20/21 Semester 2
 *
 * @author A0308382A
 */
public class EmptyList<T> implements SourceList<T> {
  
  @Override
  public T getFirst() {
    return null;
  }

  @Override
  public SourceList<T> getSecond() {
    return null;
  }

  @Override
  public String toString() {
    return "EmptyList";
  }

  @Override
  public int length() {
    return 0;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }

    if (object instanceof EmptyList<?>) {
      return true;
    }

    return false;
  }

  @Override
  public EmptyList<T> filter(BooleanCondition<? super T> obj) {
    return new EmptyList<>();
  }

  @Override
  public <U> EmptyList<U> map(Transformer<? super T, ? extends U> tf) {
    return new EmptyList<>();
  }
}
