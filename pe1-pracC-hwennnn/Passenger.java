/**
 *
 * @author A0308382A
 *
 */

class Passenger {
  private final int id;
  private static int lastId = 0;
  private final int stopId;

  public Passenger(int stopId) {
    this.id = Passenger.lastId;
    Passenger.lastId++;
    this.stopId = stopId;
  }

  public int getDestination() {
    return this.stopId;
  }

  public boolean hasReachedDestination(int stopId) {
    return this.stopId == stopId;
  }

  @Override
  public String toString() {
    String str = String.format("P%d->COM%d", this.id, this.stopId);

    return str;
  }
}
