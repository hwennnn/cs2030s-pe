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
  public String printTaskDetails() {
    String str = String.format("%s | Due in %d days", super.toString(),
        this.dueInDays);

    return str;
  }

  @Override
  public String printDueToday() {
    if (this.dueInDays != 0) {
      return null;
    }

    String str = String.format("%s | Due in %d days", super.toString(),
        this.dueInDays);

    return str;
  }

  @Override
  public String remindTask() {
    if (super.isTaskCompleted()) {
      return null;
    }

    String str = String.format("The task \"%s\" is due in %d days", super.getDescription(), this.dueInDays);

    return str;
  }

  @Override
  public int getRewardPoints() {
    return super.isTaskCompleted() ? this.dueInDays : 0;
  }
}
