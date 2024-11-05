class WrongTaskException extends Exception {

  public WrongTaskException(int type) {
    super(String.format("Invalid task type in input: %d", type));
  }
}
