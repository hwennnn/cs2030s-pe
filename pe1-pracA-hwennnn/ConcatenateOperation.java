/**
 *
 * @author A0308382A
 */

class ConcatenateOperation extends Operation {
  private final char operand;
  
  public ConcatenateOperation(char operand, Operand<?> o1, Operand<?> o2) {
    super(o1, o2);
    this.operand = operand;
  }

  @Override
  public Object eval() throws InvalidOperandException {
    Object first = super.getFirst().eval();
    Object second = super.getSecond().eval();

    if (!(first instanceof String) || !(second instanceof String)) {
      throw new InvalidOperandException(this.operand);
    }

    String o1 = (String) first;
    String o2 = (String) second;

    return o1 + o2;
  }
}
