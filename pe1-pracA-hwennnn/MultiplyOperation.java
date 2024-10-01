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

    if (!(first instanceof Integer) || !(second instanceof Integer)) {
      throw new InvalidOperandException(this.operand);
    }

    int o1 = (Integer) first;
    int o2 = (Integer) second;
    int res = o1 * o2;

    return res;
  }
  
}
