import cs2030s.fp.Maybe;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Represents a bank with multiple accounts and customers.
 */
public class Bank {

  private Map<Integer, Account> accounts;

  /**
   * Constructs a new Bank with the given list of accounts and customers.
   *
   * @param accounts  a map of account numbers and their associated accounts
   * @param customers an list of customers
   */
  public Bank(Map<Integer, Account> accounts) {
    this.accounts = accounts;
  }

  /**
   * Returns a stream of all accounts in the bank.
   *
   * @return a stream containing all accounts in the bank
   */
  private Stream<Account> getAccountStream() {
    return accounts.values().stream();
  }

  /**
   * Returns the account with the specified account number.
   *
   * @param number the account number to search for
   * @return the Account with the specified account number, or null if not found
   */
  private Maybe<Account> findAccount(int number) {
    // Map::get returns null if the account does not exist
    return Maybe.of(accounts.get(number));
  }

  /**
   * Calculates the total money in the bank across all accounts.
   *
   * @return the total money in the bank
   */
  public double totalMoneyInBank() {
    return this.getAccountStream()
      .filter(acct -> !acct.isClosed())
      .map(acct -> acct.getBalance())
      .reduce(0.0, (acc, curr) -> acc + curr);
  }

  /**
   * Transfers the specified amount of money between accounts.
   *
   * @param from   the account number to transfer money from
   * @param to     the account number to transfer money to
   * @param amount the amount of money to transfer
   */
  public void transfer(int from, int to, double amount) {
    Maybe<Account> fromAccount = findAccount(from)
      .filter(acct -> acct.getBalance() >= amount && !acct.isClosed());
    Maybe<Account> toAccount = findAccount(to)
      .filter(acct -> !acct.isClosed());

    Maybe<Pair<Account, Account>> result = fromAccount
      .flatMap(f -> toAccount.map(t -> f.transferTo(t, amount)));

    result.ifPresent(accounts -> 
        this.accounts.put(from, accounts.getFirst()));

    result.ifPresent(accounts ->
        this.accounts.put(to, accounts.getSecond()));
  }

  /**
   * Deposits the specified amount of money into the specified account.
   *
   * @param number the account number to deposit money into
   * @param amount the amount of money to deposit
   */
  public void deposit(int number, double amount) {
    Maybe<Account> account = findAccount(number)
      .filter(acct -> !acct.isClosed());

    Maybe<Account> result = account.map(acct -> acct.deposit(amount));

    result.ifPresent(acct -> this.accounts.put(number, acct));
  }

  /**
   * Withdraws the specified amount of money from the specified account.
   *
   * @param number the account number to withdraw money from
   * @param amount the amount of money to withdraw
   */
  public void withdraw(int number, double amount) {
    Maybe<Account> account = findAccount(number)
      .filter(acct -> !acct.isClosed());

    Maybe<Account> result = account.map(acct -> acct.withdraw(amount));

    result.ifPresent(acct -> this.accounts.put(number, acct));
  }

  /**
   * Combines two accounts and updates the accounts list.
   *
   * @param a the account number of the first account to combine
   * @param b the account number of the second account to combine
   */
  public void combineBankAccount(int a, int b) {
    Maybe<Account> accountA = findAccount(a)
      .filter(acct -> !acct.isClosed());
    Maybe<Account> accountB = findAccount(b)
      .filter(acct -> acct.isClosed());

    Maybe<Account> newAccount = accountA
      .flatMap(acctA -> accountB.map(acctB -> acctA.combine(acctB)));

    newAccount.ifPresent(acct -> this.accounts.put(a, acct));
    newAccount.ifPresent(acct -> this.accounts.remove(b));
  }

  /**
   * Return the details of all accounts in the bank as a string.
   */
  public String allAccounts() {
    return this.getAccountStream()
      .filter(acct -> !acct.isClosed())
      .sorted((x, y) -> Double.compare(y.getBalance(), x.getBalance()))
      .map(acct -> acct.toString())
      .reduce("", (acc, curr) -> acc + curr + "\n");
  }

  /**
   * Closes the account with the specified account number and removes it from the accounts list.
   *
   * @param number the account number of the account to close
   */
  public void closeAccount(int number) {
    Maybe<Account> account = findAccount(number)
      .map(acct -> acct.close());

    account.ifPresent(acct -> this.accounts.put(number, acct));
  }

  /**
   * Checks if this bank is equals to another bank, by comparing the accounts.
   *
   * @param o the object to compare against
   * @return true if the two banks are equal; false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (o instanceof Bank) {
      Bank c = (Bank) o;
      return c.accounts.equals(this.accounts);
    }
    return false;
  }

  /**
   * Return a string representation of the map of accounts.
   *
   * @return a string representation of this bank.
   */
  @Override
  public String toString() {
    return this.accounts.toString();
  }
}
