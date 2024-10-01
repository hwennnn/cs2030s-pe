public class StringToLength implements Transformer<String, Integer> {

  @Override
  public Integer transform(String t) {
    return t.length();
  }
}
