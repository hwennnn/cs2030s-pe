/**
 *
 * @author A0308382A
 *
 */

class XorOperation extends Operation {
  private final char operand;
 
  public XorOperation(char operand, Operand<?> o1, Operand<?> o2) {
    super(o1, o2);
    this.operand = operand;
  }

  @Override
  public Object eval() throws InvalidOperandException {
    Object first = super.getFirst().eval();
    Object second = super.getSecond().eval();

    if (!(first instanceof Boolean) || !(second instanceof Boolean)) {
      throw new InvalidOperandException(this.operand);
    }

    Boolean o1 = (Boolean) first;
    Boolean o2 = (Boolean) second;

    return o1 ^ o2;
  }
}

