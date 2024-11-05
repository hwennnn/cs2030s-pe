/**
 *
 * @author A0308382A
 *
 */

class DepartureEvent extends Event {
  private final Passenger passenger;

  public DepartureEvent(double time, Passenger passenger) {
    super(time);
    this.passenger = passenger;
  }

  @Override
  public Event[] simulate() {
    return new Event[] {};
  }

  @Override
  public String toString() {
    String str = String.format("%s %s departs", super.toString(), this.passenger);

    return str;
  }
}
