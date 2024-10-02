/**
 *
 * @author A0308382A
 *
 */

class Stop {
  private final int id;
  private final Queue<Passenger> queue;
  
  public Stop(int id, int capacity) {
    this.id = id;
    this.queue = new Queue<Passenger>(capacity);
  }

  public boolean addPassenger(Passenger passenger) {
    return this.queue.enq(passenger);
  }

  public Passenger removePassenger() {
    return this.queue.deq();
  }

  public boolean isFull() {
    return this.queue.isFull();
  }

  public boolean isEmpty() {
    return this.queue.isEmpty();
  }

  @Override
  public String toString() {
    String str = String.format("COM%d %s", this.id, this.queue);

    return str;
  }
}
