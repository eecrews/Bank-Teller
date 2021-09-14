//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P04 Exceptional Bank Teller
// Files:           BankAccount.java, BankAccountTester.java, BankTeller.java,
//                  BankTellerTester.java
// Course:          CS 300

import java.io.File;

/*
 * This class is a tester for the BankTeller class's public behaviors.
 */

public class BankTellerTester {

  /*
   * Checks whether the BankTeller.addBankAccount() method throws an IllegalStateException when it
   * is passed a bank account with an identifier already used.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */

  public static boolean testBankTellerAddBankAccountUsedIdentifier() {
    try {
      BankAccount firstAccount = new BankAccount("Test", 20);
      BankAccount secondAccount = new BankAccount("Test", 30);
      BankTeller myTeller = new BankTeller();
      myTeller.addAccount(firstAccount);
      myTeller.addAccount(secondAccount);
    } catch (IllegalStateException e) {
      return true;
    }
    return false;
  }

  /*
   * Checks whether the constructor of BankTeller class creates a new BankTeller object with an
   * empty ArrayList of bank accounts.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */

  public static boolean testBankTellerConstructor() {
    BankTeller myTeller = new BankTeller();
    if (myTeller.getAccountsCount() == 0)
      return true;
    return false;
  }

  /*
   * This method checks whether the BankTeller.loadTransactions() method that takes a File parameter
   * throws a FileNotFoundException, when it is passed a File object that does not correspond to an
   * actual file within the file system, and a non null reference of type BankAccount.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */

  public static boolean testBankTellerLoadTransactionsFileNotFound() {
    try {
      File f = new File("Random string");
      BankTeller myTeller = new BankTeller();
      BankAccount myAccount = new BankAccount("Test", 20);
      myTeller.addAccount(myAccount);
      myTeller.loadTransactions(f, myAccount);
    } catch (java.io.FileNotFoundException e) {
      return true;
    }
    return false;
  }

  /*
   * Calls the test methods defined in this BankTellerTester class
   * 
   * @param args - input arguments
   */

  public static void main(String[] args) {
    System.out.println(testBankTellerAddBankAccountUsedIdentifier());
    System.out.println(testBankTellerConstructor());
    System.out.println(testBankTellerLoadTransactionsFileNotFound());

    /*
     * BankTeller myBankTeller = new BankTeller(); BankAccount myAccount = new BankAccount("Test",
     * 30); myBankTeller.addAccount(myAccount); myBankTeller.addAccount(new BankAccount("Tester",
     * 40));
     * 
     * try { myBankTeller.addTransaction("1 50", myAccount); }
     * catch(java.util.zip.DataFormatException e) { System.out.println("Error."); }
     * 
     * String[] myArray = myBankTeller.findAccount("Test").getMostRecentTransactions(); for(int i=0;
     * i<myArray.length; i++) { System.out.println(myArray[i]); }
     */
  }
}
