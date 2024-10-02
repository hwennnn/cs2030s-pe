/**
 *
 * @author A0308382A
 *
 */

class Bus {
  private final int maxCapacity;
  private final int numberOfStops;
  private final int id;
  private int currentStop;
  private int currentCapacity;
  private final Queue<Passenger>[] queue;

  private static int lastId = 0;


  public Bus(int capacity, int numberOfStops) {
    this.maxCapacity = capacity;
    this.numberOfStops = numberOfStops;

    @SuppressWarnings("unchecked")
    Queue<Passenger>[] temp  = (Queue<Passenger>[]) new Queue<?>[numberOfStops];
    this.queue = temp;

    for (int i = 0; i < numberOfStops; i++) {
      this.queue[i] = new Queue<Passenger>(capacity);
    }

    this.currentCapacity = 0;
    this.currentStop = 0;
    this.id = Bus.lastId;
    Bus.lastId++;
  }

  public boolean canPassengerBoard() {
    return this.currentCapacity != this.maxCapacity &&
      !this.queue[this.currentStop].isFull();
  }

  public Bus board(Passenger passenger) throws CannotBoardException {
    int destinationId = passenger.getDestination();

    if (this.currentCapacity == this.maxCapacity || 
        !this.queue[destinationId].enq(passenger)) {
      throw new CannotBoardException("Bus is full"); 
        }

    this.currentCapacity++;
    return this;
  }

  public Bus alight() {
    while (!this.queue[this.currentStop].isEmpty()) {
      this.queue[this.currentStop].deq();
      this.currentCapacity--;
    }

    return this;
  }

  public Bus move() {
    this.currentStop = (this.currentStop + 1) % this.numberOfStops;
    return this;
  }

  public int getCurrentStop() {
    return this.currentStop;
  }

  @Override
  public String toString() {
    String queueString = "";

    for (int i = 0; i < this.numberOfStops; i++) {
      queueString += this.queue[i].toString() + " ";
    }

    String str = String.format("B%d@COM%d passengers: %s", this.id, this.currentStop,
        queueString);

    return str;
  }
}
