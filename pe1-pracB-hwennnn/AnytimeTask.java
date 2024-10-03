/**
 *
 * @author A0308382A
 *
 */

class AnytimeTask extends Task {

  public AnytimeTask(String description) {
    super(description);
  }

  @Override
  public String printTaskDetails() {
    String str = String.format("%s", super.toString());

    return str;
  }

  @Override
  public String printDueToday() {
    return null;
  }

  @Override
  public String remindTask() {
    return null;
  }

  @Override
  public int getRewardPoints() {
    return 0;
  }
}
