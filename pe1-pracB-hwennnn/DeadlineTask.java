/**
 *
 * @author A0308382A
 *
 */

class DeadlineTask extends Task {
  private final int dueInDays;
  
  public DeadlineTask(String description, int dueInDays) {
    super(description);
    this.dueInDays = dueInDays;
  }

  @Override
  public void printTaskDetails() {
    String str = String.format("%s | Due in %d days", super.toString(),
        this.dueInDays);

    System.out.println(str);
  }

  @Override
  public void printDueToday() {
    if (this.dueInDays != 0) {
      return;
    }

    String str = String.format("%s | Due in %d days", super.toString(),
        this.dueInDays);

    System.out.println(str);
  }

  @Override
  public void remindTask() {
    if (super.isTaskCompleted()) {
      return;
    }

    String str = String.format("The task \"%s\" is due in %d days", super.getDescription(), this.dueInDays);

    System.out.println(str);
  }

  @Override
  public int getRewardPoints() {
    return super.isTaskCompleted() ? this.dueInDays : 0;
  }
}
