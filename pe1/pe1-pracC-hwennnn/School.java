/**
 *
 * @author A0308382A
 *
 */

class School {
  private Stop[] stops;

  public School(Stop[] stops) {
    this.stops = stops;
  }

  public Stop getBusStop(int id) {
    return this.stops[id];
  }
  
}
