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
  public void printTaskDetails() {
    String str = String.format("%s", super.toString());

    System.out.println(str);
  }

  @Override
  public void printDueToday() {

  }

  @Override
  public void remindTask() {

  }

  @Override
  public int getRewardPoints() {
    return 0;
  }
}
