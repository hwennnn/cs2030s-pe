/**
 * CS2030S PE1 Question 2
 * AY20/21 Semester 2
 *
 * @author A0308382A
 */
 public class Pair<T> implements SourceList<T> {
  private T first;
  private SourceList<T> second;

  public Pair(T first, SourceList<T> second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public T getFirst() {
    return this.first;
  }

  @Override
  public SourceList<T> getSecond() {
    return this.second;
  }

  @Override
  public String toString() {
    return this.first + ", " + this.second;
  }

  @Override
  public int length() {
    return 1 + this.second.length();
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }

    if (object instanceof Pair<?> other) {
      return this.first.equals(other.first) && this.second.equals(other.second);
    }

    return false;
  }

  @Override
  public SourceList<T> filter(BooleanCondition<? super T> obj) {
    if (obj.test(this.first)) {
     return new Pair<>(this.first, this.second.filter(obj)); 
    }

    return this.second.filter(obj);
  }

  @Override
  public <U> SourceList<U> map(Transformer<? super T, ? extends U> tf) {
    SourceList<U> res = new Pair<U>(tf.transform(this.first), this.second.map(tf));
    return res;
  }
}
