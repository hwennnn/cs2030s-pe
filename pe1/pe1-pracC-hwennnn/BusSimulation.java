import java.util.Scanner;

/**
 * This class implements a bus simulation.
 *
 * @author A0308382A
 * @version CS2030S AY23/24 Semester 2
 */ 
class BusSimulation extends Simulation {
  private School school;

  private static final double INTER_STOP_TRAVEL_TIME = 1.0;

  /** 
   * The list of passengner and bus events to populate
   * the simulation with.
   */
  public Event[] initEvents;

  /** 
   * Constructor for a bus simulation. 
   *
   * @param sc A scanner to read the parameters from.  
   */
  public BusSimulation(Scanner sc) {

    int numStops = sc.nextInt();
    int numBuses = sc.nextInt();
    int numPassengers = sc.nextInt();

    initEvents = new Event[numBuses + numPassengers];

    Stop[] stops = new Stop[numStops];
    for (int i = 0; i < numStops; i++) {
      int capacity = sc.nextInt();
      stops[i] = new Stop(i, capacity);
    }

    this.school = new School(stops);
    int id = 0;

    for (int i = 0; i < numBuses; i++) {
      double leaveTime = sc.nextDouble();
      int capacity = sc.nextInt();
      Bus bus = new Bus(capacity, numStops);
      initEvents[id] = new BusEvent(leaveTime, bus, this.school);
      id += 1;
    }

    while (sc.hasNextDouble()) {
      double arrivalTime = sc.nextDouble();
      int source = sc.nextInt();
      int destination = sc.nextInt();
      Passenger passenger = new Passenger(destination);
      Stop startingStop = this.school.getBusStop(source);
      initEvents[id] = new ArrivalEvent(arrivalTime, passenger, startingStop); 
      id += 1;
    }
  }

  /**
   * Retrieve an array of events to populate the 
   * simulator with.
   *
   * @return An array of events for the simulator.
   */
  @Override
  public Event[] getInitialEvents() {
    return initEvents;
  }
}
