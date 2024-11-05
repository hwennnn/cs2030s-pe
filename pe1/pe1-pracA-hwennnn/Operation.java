/**
 * CS2030S PE1 Question 1
 * AY20/21 Semester 2
 *
 * @author A0308382A
 */

abstract class Operation implements Expression {
  private Expression o1;
  private Expression o2;

  public Operation(Expression o1, Expression o2) {
    this.o1 = o1;
    this.o2 = o2;
  }

  public Expression getFirst() {
    return this.o1;
  }

  public Expression getSecond() {
    return this.o2;
  }

  public static Operation of(char operand, Expression o1, Expression o2) {
    if (o1 == null || o2 == null) {
      return null;
    }

    if (operand == '*') {
      return new MultiplyOperation(operand, o1, o2);
    } else if (operand == '+') {
      return new ConcatenateOperation(operand, o1, o2);
    } else if (operand == '^') {
      return new XorOperation(operand, o1, o2);
    }

    return null;
  }
}
