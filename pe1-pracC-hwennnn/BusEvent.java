/**
 *
 * @author A0308382A
 *
 */

class BusEvent extends Event {
  private final Bus bus;
  private final Stop stop;
  private final School school;

  private static final double INTER_STOP_TRAVEL_TIME = 1.0;

  public BusEvent(double time, Bus bus, Stop stop, School school) {
    super(time);
    this.bus = bus;
    this.stop = stop;
    this.school = school;
  }

  @Override
  public Event[] simulate() {
    this.bus.alight();

    try {
      while (this.bus.canPassengerBoard() && !this.stop.isEmpty()) {
        this.bus.board(this.stop.removePassenger());
      }
    } catch (CannotBoardException exception) {

    }

    this.bus.move();

    Stop nextStop = this.school.getBusStop(this.bus.getCurrentStop());
    double newTime = super.getTime() + BusEvent.INTER_STOP_TRAVEL_TIME;

    return new Event[] {
      new BusEvent(newTime, this.bus, nextStop, this.school)
    };
  }

  @Override
  public String toString() {
    String str = String.format("%s %s Stop: %s", super.toString(), this.bus, this.stop);

    return str;
  }
}