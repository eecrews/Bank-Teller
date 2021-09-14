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
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.ArrayList;
import java.util.zip.DataFormatException;

/*
 * This class models a very simple account at a bank.
 */

public class BankAccount {

  private String identifier;
  private int balance;
  private ArrayList<String> transactions;

  /*
   * Creates a new bank account with a given account identifier and an initial balance.
   * 
   * @param identifier - this account's unique identifier
   * 
   * @param initialBalance - this account's initial balance
   * 
   * @throws java.lang.IllegalArgumentException - with a descriptive error message if initBalance is
   * less than 10
   */

  public BankAccount(String identifier, int initialBalance) {
    transactions = new ArrayList<String>();

    if (initialBalance < 10)
      throw new IllegalArgumentException("Initial balance cannot be less than 10.");
    this.identifier = identifier;
    balance = initialBalance;
    transactions.add("1" + " " + initialBalance);
  }

  /*
   * Gets the unique identifier of this account
   * 
   * @return identifier - the unique identifier of this account
   */

  public String getID() {
    return identifier;
  }

  /*
   * Gets the current balance of this bank account
   * 
   * @return balance - current balance of this bank account
   */

  public int getBalance() {
    return balance;
  }

  /*
   * Checks if an other bank account is equal to this one
   * 
   * @param other - another BankAccount object
   * 
   * @return true if this bankAccount's identifier equals the other bankAccount's identifier. The
   * comparison is case sensitive.
   */

  public boolean equals(BankAccount other) {
    return (identifier.equals(other.getID()));
  }

  /*
   * This method deposits an amount to this bank account. It also adds the transaction /"1 " +
   * depositAmount/ to this account list of transactions and updates this bank account's balance.
   * 
   * @param depositAmount - the amount of money to deposit to this bank account
   * 
   * @throws java.lang.IllegalArgumentException - with a descriptive error message if depositAmount
   * is negative
   */

  public void deposit(int depositAmount) {
    if (depositAmount <= 0)
      throw new IllegalArgumentException("Amount to deposit cannot be negative.");

    balance += depositAmount;
    transactions.add("1" + " " + depositAmount);
  }

  /*
   * This method withdraws a specific amount of money. It also adds the transaction /"0 " +
   * withdrawalAmount/ to this accunt's list of transactions and updates this bank account's
   * balance.
   * 
   * @param withdrawAmount - the amount of money to withdraw from this bank account
   * 
   * @throws java.util.zip.DataFormatException - with a descriptive error message if
   * withdrawalAmount is negative or is not a multiple of 10
   * 
   * @throws java.lang.IllegalStateException - if the withdrawalAmount is larger than this bank
   * account's balance
   */

  public void withdraw(int withdrawAmount) throws java.util.zip.DataFormatException {
    if (withdrawAmount % 10 != 0 || withdrawAmount <= 0)
      throw new DataFormatException("Withdraw amount must be a multiple of 10 and non-negative.");
    if (withdrawAmount > balance)
      throw new IllegalStateException(
          "Withdraw amount must be less than or equal to current " + "balance.");

    balance -= withdrawAmount;
    transactions.add("0" + " " + withdrawAmount);
  }

  /*
   * Gets the most recent FIVE transactions in an array of length 5. This array may contain null
   * references if the total number of transactions is less than 5. If getTransactionsCount() is
   * less than 5, these transactions should be stored at the range of indices 0 ..
   * getTransactionsCount()-1. For instance, if the total number of transactions is 0, this array
   * will contain five null references. If the total number of transactions is 1, it will contain
   * the transaction at index 0, followed by 4 null references, and so on.
   * 
   * @return the most recent transactions in an array that may contain up to 5 string references
   */

  public String[] getMostRecentTransactions() {
    String[] mostRecentTransactions = new String[5];
    int count = 0;

    for (int i = transactions.size() - 1; i >= 0; i--) {
      if (count < 5) {
        mostRecentTransactions[count] = transactions.get(i);
        count++;
      }
    }

    return mostRecentTransactions;
  }

}
