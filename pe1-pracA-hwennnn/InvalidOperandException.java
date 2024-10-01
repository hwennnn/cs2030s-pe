/**
 * CS2030S PE1 Question 1
 * AY20/21 Semester 2
 *
 * @author A0308382A
 */

class InvalidOperandException extends RuntimeException {

  public InvalidOperandException(char operand) {
    super("ERROR: Invalid operand for operator " + operand);
  }
}
