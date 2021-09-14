//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P04 Exceptional Bank Teller
// Files:           BankAccount.java, BankAccountTester.java, BankTeller.java,
//                  BankTellerTester.java
// Course:          CS 300, fall, 2019
//
// Author:          Erin Crews
// Email:           eecrews@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    N/A
// Partner Email:   N/A
// Partner Lecturer's Name: N/A
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         NONE
// Online Sources:  https://www.java67.com/2012/11/how-to-read-file-in-java-using-scanner-example.html
//                  I used this source to familiarize myself with how to use scanner to read a file.
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/*
 * This class models the BankTeller data type.
 */

public class BankTeller {
  private ArrayList<BankAccount> accounts;

  /*
   * Creates a new BankTeller object with an empty list of accounts
   */

  public BankTeller() {
    accounts = new ArrayList<BankAccount>();
  }

  /*
   * Adds newAccount to the list of accounts of this BankTeller
   * 
   * @param newAccount - a new account to add
   * 
   * @throws java.lang.IllegalStateException - with a descriptive error message if the accountID of
   * newAccount is used by another account already added to the list of accounts
   * 
   * @throws java.lang.IllegalArgumentException - with a descriptive error message if newAccount is
   * null
   */

  public void addAccount(BankAccount newAccount) {
    if (newAccount == null) {
      throw new IllegalArgumentException("The account to be added cannot be null.");
    }
    for (int i = 0; i < accounts.size(); i++) {
      if (newAccount.equals(accounts.get(i)))
        throw new IllegalStateException("The ID of the account to be added already matches the"
            + " ID of an account in the list. Please try again.");
    }
    accounts.add(newAccount);
  }

  /*
   * Returns the bank account that has exactly the provided identifier. Case sensitive comparison
   * must be considered.
   * 
   * @param id - a string that represents an identifier of a bank account
   * 
   * @return a reference to the bank account whose account identifier has an exact match with the
   * provided string
   * 
   * @throws java.util.NoSuchElementException - with a descriptive error message if no account in
   * this bankTeller's accounts list has the provided id
   */

  public BankAccount findAccount(String id) throws java.util.NoSuchElementException {
    for (int i = 0; i < accounts.size(); i++) {
      if (id.equals(accounts.get(i).getID())) {
        return accounts.get(i);
      }
    }
    throw new java.util.NoSuchElementException(
        "Could not find account in list that matches specified ID.");
  }

  /*
   * Adds a new transaction to the account's list of transactions. When added, a withdrawal or
   * deposit transaction should change the account's balance.
   * 
   * @param transaction - to add
   * 
   * @param account - bank account
   * 
   * @throws java.util.zip.DataFormatException - if the format of the transaction is not correct
   * 
   * @throws java.lang.NullPointerException - if account is null
   */

  public void addTransaction(String transaction, BankAccount account)
      throws java.util.zip.DataFormatException {
    if (account == null) {
      throw new NullPointerException("Account cannot be null.");
    }

    String[] splitString = transaction.trim().split("\\s+");
    boolean firstHalf = false;
    boolean secondHalf = true;
    if (splitString[0].equals("0") || splitString[0].equals("1"))
      firstHalf = true;
    try {
      int secondHalfInt = Integer.parseInt(splitString[1]);
    } catch (NumberFormatException | NullPointerException e) {
      secondHalf = false;
    }

    if (firstHalf == false || secondHalf == false) {
      throw new java.util.zip.DataFormatException(
          "Transaction format is incorrect. Please try again.");
    }

    if (splitString[0].equals("0"))
      account.withdraw(Integer.parseInt(splitString[1]));
    else if (splitString[0].equals("1"))
      account.deposit(Integer.parseInt(splitString[1]));
  }

  /*
   * Loads a set of transactions from a provided file object. Each transaction is in a separate
   * line. Each transaction line should contain two items: the transaction code "0" or "1" followed
   * by the transaction amount, separated by spaces. Extra spaces at the beginning and at the end of
   * a transaction line should be ignored. Not correctly formatted lines must be skipped. Valid
   * transactions must change the balance of the bank account. If java.util.Scanner object is used
   * to read from the file object, make sure to close the scanner object whenever a
   * FileNotFoundException was thrown or not.
   * 
   * @param account - a reference to a BankAccount object
   * 
   * @param file - a java.io.File object referring to a file that contains a set of transactions,
   * each in one line
   * 
   * @throws java.lang.NullPointerException - if account is null
   * 
   * @throws java.io.FileNotFoundException - if the file object does not correspond to an actual
   * file within the file system.
   */

  public void loadTransactions(File file, BankAccount account)
      throws java.io.FileNotFoundException {
    if (!file.exists())
      throw new java.io.FileNotFoundException("File does not exist. Please try again.");
    if (account == null)
      throw new NullPointerException("Account cannot be null.");

    Scanner fileScanner = new Scanner(file);

    try {
      while (fileScanner.hasNextLine()) {
        String transaction = fileScanner.nextLine();
        addTransaction(transaction, account);
      }
    } catch (java.util.zip.DataFormatException e) {
      System.out.println(e.getMessage());
    } finally {
      fileScanner.close();
    }
  }

  /*
   * Returns the total number of accounts created so far (i.e., the size of the Arraylist of
   * accounts)
   * 
   * @return the total number of accounts added to this BankTeller
   */

  public int getAccountsCount() {
    return accounts.size();
  }
}

