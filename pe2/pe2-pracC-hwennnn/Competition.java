import cs2030s.fp.Maybe;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Represents a competition between teams, with methods for scoring, 
 * penalizing, transferring points between teams, and combining teams. 
 * Also provides methods for printing the leaderboard and removing 
 * teams from the competition.
 */
public class Competition {

  private Map<Integer, Team> teams;

  /**
   * Constructs a new Competition object with the given teams.
   *
   * @param teams a map of team IDs to Team objects
   */
  public Competition(Map<Integer, Team> teams) {
    this.teams = teams;
  }

  /**
   * Returns a stream of all teams in the competition.
   *
   * @return a stream containing all accounts in the bank
   */
  private Stream<Team> getTeams() {
    return teams.values().stream();
  }


  /**
   * Returns the Team with the given ID, or null if no such team exists.
   *
   * @param id the ID of the team to find
   * @return the Team with the given ID, or null if no such team exists
   */
  private Maybe<Team> findTeam(int id) {
    // Map::get(id) return null if id does not exist.
    return Maybe.of(teams.get(id));
  }

  /**
   * Calculates the total number of points earned by all teams in the
   * competition.  Teams with negative points are not included.
   *
   * @return total points earned by teams with positive points in the 
   * competition
   */
  public double totalPoints() {
    return this.getTeams()
      .filter(t -> !t.isDisqualified())
      .map(t -> t.getPoints())
      .reduce(0.0, (acc, curr) -> acc + curr);
  }

  /**
   * Transfers the given amount of points from one team to another.
   * The from team must have positive points and the to team must have
   * a negative points.  Otherwise, nothing happens.
   *
   * @param from the ID of the team to transfer points from
   * @param to the ID of the team to transfer points to
   * @param amount the number of points to transfer
   */
  public void transfer(int from, int to, double amount) {
    Maybe<Team> fromTeam = findTeam(from).filter(t -> t.getPoints() > 0);
    Maybe<Team> toTeam = findTeam(to).filter(t -> t.getPoints() < 0);

    Maybe<Pair<Team, Team>> result = fromTeam
        .flatMap(f -> toTeam.map(t -> f.transferTo(t, amount)));

    result.ifPresent(pairs -> this.teams.put(from, pairs.getFirst()));
    result.ifPresent(pairs -> this.teams.put(to, pairs.getSecond()));
  }

  /**
   * Adds the given amount of points to the team with the given ID.
   * If the given ID is invalid, nothing happen.
   *
   * @param id the ID of the team to score points for
   * @param points the number of points to add
   */
  public void score(int id, double points) {
    Maybe<Team> team = findTeam(id).map(t -> t.score(points));
    team.ifPresent(t -> this.teams.put(id, t));
  }

  /**
   * Subtracts the given amount of points from the team with the given ID.
   * If the given ID is invalid, nothing happen.
   *
   * @param id the ID of the team to penalize
   * @param points the number of points to subtract
   */
  public void penalize(int id, double points) {
    Maybe<Team> team = findTeam(id).map(t -> t.penalize(points));
    team.ifPresent(t -> this.teams.put(id, t));
  }

  /**
   * Combines two teams by merging their points and removing 
   * the original teams.
   *
   * @param a the ID of the first team to combine
   * @param b the ID of the second team to combine
   */
  public void mergeTeams(int a, int b) {
    Maybe<Team> teamA = findTeam(a).filter(t -> !t.isDisqualified());
    Maybe<Team> teamB = findTeam(b).filter(t -> !t.isDisqualified());

    Maybe<Team> mergedTeam = teamA.flatMap(ta -> teamB.map(tb -> ta.mergeWith(tb)));

    mergedTeam.ifPresent(t -> this.teams.put(a, t));
    mergedTeam.ifPresent(t -> this.teams.remove(b));
  }

  /**
   * Returns a string representing the leaderboard for the competition, 
   * sorted in ascending order of points earned.
   *
   * @return The leader board as a string
   */
  public String leaderBoard() {
    return this.getTeams()
      .filter(t -> !t.isDisqualified())
      .sorted((x, y) -> Double.compare(y.getPoints(), x.getPoints()))
      .map(t -> t.getTeamID() + " | " + t.toString() + "\n")
      .reduce("", (acc, curr) -> acc + curr);
  }

  /**
   * Disqualify the team with the given ID from the competition.
   * If the given ID is invalid, nothing happens.
   *
   * @param id the ID of the team to remove
   */
  public void disqualify(int id) {
    Maybe<Team> team = findTeam(id).map(t -> t.disqualify());
    team.ifPresent(t -> this.teams.put(id, t));
  }

  /**
   * Checks if this competition is equals to another competition, by comparing the teams.
   *
   * @param o the object to compare against
   * @return true if the two competitions are equal; false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (o instanceof Competition) {
      Competition c = (Competition) o;
      return c.teams.equals(this.teams);
    }
    return false;
  }

  /**
   * Return a string representation of the map of teams.
   *
   * @return a string representation of this competition.
   */
  @Override
  public String toString() {
    return this.teams.toString();
  }
}
