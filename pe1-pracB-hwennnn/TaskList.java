/**
 * CS2030S AY22/23 Sem 2 PE1
 * @author A0308382A
 * */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Encapsulate a list of TODO tasks.
 */
class TaskList {
  private int numOfTasks; // The number of tasks in the list.
  private Array<Task> tasks;

  /**
   * A constructor that reads in the list from the standard input.
   **/
  public TaskList() {
    this(new Scanner(System.in));
  }

  /**
   * A constructor that reads in the list from the standard input.
   * @throws FileNotFoundException
   **/
  public TaskList(String filename) throws FileNotFoundException {
    this(new Scanner(new File(filename)));
  }

  /**
   * A constructor that reads in the list using the given scanner.
   * If the input contains an invalid type, print an error message.
   * @param sc The Scanner to read from.
   **/
  private TaskList(Scanner sc) {
    this.loadTasks(sc);
  }

  /**
   * Load the tasks from the given scanner.
   * @param sc The scanner to load from.
   * @return false if the input contains a wrong type; true otherwise.
   **/
  private void loadTasks(Scanner sc) {
    this.numOfTasks = Integer.parseInt(sc.nextLine().trim());
    this.tasks = new Array<Task>(numOfTasks);

    int i = 0;
    while (i < this.numOfTasks) {
      String text = sc.nextLine().trim();
      String[] arguments = text.split(",");
      try {
        this.tasks.set(i, Task.createTask(arguments));
      } catch (WrongTaskException exception) {
        System.out.println(exception.getMessage());
        sc.close();
        break;
      }
      i = i + 1;
    }
  }


  /**
   * Print the description of all tasks.
   **/
  public void printTaskDescriptions() {
    for (int i = 0; i < this.numOfTasks; i++) {
      this.tasks.get(i).printTaskDescriptions();
    }
  }

  /**
   * Print the details of all tasks.
   **/
  public void printTaskDetails() {
    for (int i = 0; i < this.numOfTasks; i++) {
      this.tasks.get(i).printTaskDetails();
    }
  }

  /**
   * Calculate the total reward points earned.
   * @return The reward points.
   **/
  public int getRewardPoints() {
    int sum = 0;

    for (int i = 0; i < this.numOfTasks; i++) {
      sum += this.tasks.get(i).getRewardPoints();
    }
    return sum;
  }

  /**
   * Print all the tasks that are due today.
   **/
  public void printDueToday() {
    for (int i = 0; i < this.numOfTasks; i++) {
      this.tasks.get(i).printDueToday();
    }
  }

  /**
   * Remind users about all incomplete tasks with deadline.
   */
  public void remindAll() {
    for (int i = 0; i < this.numOfTasks; i++) {
      this.tasks.get(i).remindTask();
    }
  }

  /**
   * Mark a task as complete.
   * @param i The index of the task to complete.
   */
  public void completeTask(int i) {
    this.tasks.get(i).complete();
  }
}
