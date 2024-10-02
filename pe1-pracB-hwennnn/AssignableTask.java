/**
 *
 * @author A0308382A
 *
 */

class AssignableTask extends Task {
  private final int dueInDays;
  private final String assignees;
  
  public AssignableTask(String description, int dueInDays, String assignees) {
    super(description);
    this.dueInDays = dueInDays;
    this.assignees = assignees;
  }

  @Override
  public void printTaskDetails() {
    String str = String.format("%s | Due in %d days | Assigned to %s", 
        super.toString(), this.dueInDays, this.assignees);

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

    String str = String.format("Sending a reminder to complete \"%s\" to %s",
        super.getDescription(), this.assignees);

    System.out.println(str);
  }

  @Override
  public int getRewardPoints() {
    return super.isTaskCompleted() ? this.dueInDays : 0;
  }
}
