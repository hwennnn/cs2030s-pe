/**
 *
 * @author A0308382A
 *
 */

abstract class Task {
  private final int id;
  private final String description;
  private boolean isCompleted;

  // The types of tasks
  private static final int ANYTIME = 0;
  private static final int DEADLINE = 1;
  private static final int ASSIGNABLE = 2;

  private static int lastId = 0;
  

  public Task(String description) {
    this.description = description;
    this.isCompleted = false;
    this.id = Task.lastId;
    Task.lastId++;
  }

  public static Task createTask(String [] args) throws WrongTaskException {
    int type = Integer.parseInt(args[0]);
    String description = args[1];

    if (type == Task.ANYTIME) {
      return new AnytimeTask(description);
    } else if (type == Task.DEADLINE) {
      int dueInDays = Integer.parseInt(args[2]);
      return new DeadlineTask(description, dueInDays);
    } else if (type == Task.ASSIGNABLE) {
      int dueInDays = Integer.parseInt(args[2]);
      String assignees = args[3];
      return new AssignableTask(description, dueInDays, assignees);
    } 

    throw new WrongTaskException(type);
  }

  public String getDescription() {
    return this.description;
  }

  public boolean isTaskCompleted() {
    return this.isCompleted;
  }

  public void printTaskDescriptions() {
    String str = String.format("%s %s", this.id, this.description);

    System.out.println(str);
  }
  
  abstract public void printTaskDetails();

  public void complete() {
    this.isCompleted = true;
  }

  abstract public void printDueToday();

  abstract public void remindTask();

  abstract public int getRewardPoints();

  @Override
  public String toString() {
    String complete = this.isCompleted ? "X" : " ";
    String str = String.format("%s [%s] %s", this.id, complete, this.description);

    return str;
  }
}
