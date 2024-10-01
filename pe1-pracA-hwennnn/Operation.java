/**
 * CS2030S PE1 Question 1
 * AY20/21 Semester 2
 *
 * @author A0308382A
 */

abstract class Operation {
  private Operand<?> o1;
  private Operand<?> o2;

  public Operation(Operand<?> o1, Operand<?> o2) {
    this.o1 = o1;
    this.o2 = o2;
  }

  public Operand<?> getFirst() {
    return this.o1;
  }

  public Operand<?> getSecond() {
    return this.o2;
  }

  abstract Object eval() throws InvalidOperandException;

  public static Operation of(char operand, Object o1, Object o2) {
    Operand<?> oper1 = null;
    Operand<?> oper2 = null;

    if (o1 instanceof Operand<?>) {
      oper1 = (Operand<?>) o1;
    } else if (o1 instanceof Operation operation1) {
      oper1 = new Operand(operation1.eval());
    }

    if (o2 instanceof Operand<?>) {
      oper2 = (Operand<?>) o2;
    } else if (o2 instanceof Operation operation2) {
      oper2 = new Operand(operation2.eval());
    }

    if (oper1 == null || oper2 == null) {
      return null;
    }

    if (operand == '*') {
      return new MultiplyOperation(operand, oper1, oper2);
    } else if (operand == '+') {
      return new ConcatenateOperation(operand, oper1, oper2);
    } else if (operand == '^') {
      return new XorOperation(operand, oper1, oper2);
    }

    return null;
  }
}
