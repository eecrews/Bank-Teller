//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P04 Exceptional Bank Teller
// Files:           BankAccount.java, BankAccountTester.java, BankTeller.java,
//                  BankTellerTester.java
// Course:          CS 300

/*
 * This class represents a tester for the BankAccount class's public behaviors.
 */

public class BankAccountTester {

  /*
   * This method checks whether the BankAccount constructor throws an IllegalArgumentException when
   * it is passed a balance smaller than 10.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */

  public static boolean testBankAccountConstructorNotValidInitialBalance() {
    try {
      BankAccount myAccount = new BankAccount("Test", 5);
    } catch (IllegalArgumentException e) {
      return true;
    }
    return false;
  }

  /*
   * Calls the constructor of BankAccount class to create a new BankAccount object with a given id
   * and a valid initial balance (greater of equal to 10). Checks whether the new account is created
   * with the provided account id and balance. It checks also that the list of transactions of the
   * created account contains only one transaction /"1 " + the initial balance/
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */

  public static boolean testBankAccountConstructorValidInitialBalance() {
    try {
      BankAccount myAccount = new BankAccount("Test", 15);
    } catch (IllegalArgumentException e) {
      return false;
    }
    return true;
  }

  /*
   * Checks whether BankAccount.deposit() method throws an IllegalArgumentException when it is
   * passed a negative number. The balance of the bank account should not change after the method
   * call returns.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */

  public static boolean testBankAccountDepositNegativeAmount() {
    try {
      BankAccount myAccount = new BankAccount("Test", 20);
      myAccount.deposit(-15);
    } catch (IllegalArgumentException e) {
      return true;
    }
    return false;

  }

  /*
   * Checks whether BankAccount.equals() method returns true when it compares a bank account to
   * another one having the same account identifier (case sensitive comparison); and it returns
   * false otherwise.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */

  public static boolean testBankAccountEquals() {
    BankAccount myAccount = new BankAccount("Test", 20);
    BankAccount sameID = new BankAccount("Test", 30);

    return myAccount.equals(sameID);
  }

  /*
   * Checks whether BankAccount.withdraw() method throws a DataFormatException when it is passed a
   * negative number or a number not multiple of 10. The account balance should not change after the
   * withdraw() method returns.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */

  public static boolean testBankAccountWithdrawInvalidAmount() {
    try {
      BankAccount myAccount = new BankAccount("Test", 50);
      myAccount.withdraw(-35);
    } catch (java.util.zip.DataFormatException e) {
      return true;
    }
    return false;

  }

  /*
   * Checks whether BankAccount.withdraw() method throws an IllegalStateException when it is passed
   * a number larger than the account's balance. The account balance should not change after that
   * withdraw() method call returns.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */

  public static boolean testBankAccountWithdrawLargerOfBalanceAmount() {
    try {
      BankAccount myAccount = new BankAccount("Test", 20);
      myAccount.withdraw(30);
    } catch (java.util.zip.DataFormatException e) {
      return false;
    } catch (IllegalStateException e) {
      return true;
    }
    return false;
  }

  /*
   * Calls the different test methods
   * 
   * @param args - input arguments
   */

  public static void main(String[] args) {
    System.out.println(testBankAccountConstructorNotValidInitialBalance());
    System.out.println(testBankAccountConstructorValidInitialBalance());
    System.out.println(testBankAccountDepositNegativeAmount());
    System.out.println(testBankAccountEquals());
    System.out.println(testBankAccountWithdrawInvalidAmount());
    System.out.println(testBankAccountWithdrawLargerOfBalanceAmount());
  }
}
