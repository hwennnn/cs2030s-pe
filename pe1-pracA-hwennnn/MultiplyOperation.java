/**
 *
 * @author A0308382A
 *
 */

class MultiplyOperation extends Operation {
  private final char operand;

  public MultiplyOperation(char operand, Operand<?> o1, Operand<?> o2) {
    super(o1, o2);
    this.operand = operand;
  }

  @Override
  public Object eval() throws InvalidOperandException {
    Object first = super.getFirst().eval();
    Object second = super.getSecond().eval();

    if ((first instanceof Integer o1) && (second instanceof Integer o2)) {
      return o1 * o2;
    }

    throw new InvalidOperandException(this.operand);
  }
  
}
