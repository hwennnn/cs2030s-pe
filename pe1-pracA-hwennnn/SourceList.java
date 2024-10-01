/**
 * CS2030S PE1 Question 2
 * AY20/21 Semester 2
 *
 * @author A0308382A
 */
interface SourceList<T> {
  T getFirst();
  SourceList<T> getSecond();
  int length();
  SourceList<T> filter(BooleanCondition<? super T> condition);
  <U> SourceList<U> map(Transformer<? super T, ? extends U> tf);
}
