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

    if ((first instanceof String o1) && (second instanceof String o2)) {
      return o1 + o2;
    }

    throw new InvalidOperandException(this.operand);
  }
}
