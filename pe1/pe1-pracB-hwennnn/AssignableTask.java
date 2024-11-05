/**
 *
 * @author A0308382A
 *
 */

class AssignableTask extends DeadlineTask {
  private final String assignees;
  
  public AssignableTask(String description, int dueInDays, String assignees) {
    super(description, dueInDays);
    this.assignees = assignees;
  }

  @Override
  public String printTaskDetails() {
    String str = String.format("%s | Assigned to %s", 
        super.printTaskDetails(), this.assignees);

    return str;
  }

  @Override
  public String remindTask() {
    if (super.isTaskCompleted()) {
      return null;
    }

    String str = String.format("Sending a reminder to complete \"%s\" to %s",
        super.getDescription(), this.assignees);

    return str;
  }

}
