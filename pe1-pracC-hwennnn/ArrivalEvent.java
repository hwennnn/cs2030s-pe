/**
 *
 * @author A0308382A
 *
 */

class ArrivalEvent extends Event {
  private final Passenger passenger;
  private final Stop stop;

  public ArrivalEvent(double time, Passenger passenger, Stop stop) {
    super(time);
    this.passenger = passenger;
    this.stop = stop;
  }

  @Override
  public Event[] simulate() {
    if (!this.stop.addPassenger(this.passenger)) {
      return new Event[] {
        new DepartureEvent(super.getTime(), this.passenger)
      };
    }

    return new Event[] {};
  }

  @Override
  public String toString() {
    String str = String.format("%s %s arrives at %s", super.toString(), 
        this.passenger, this.stop);

    return str;
  }
}
