package com.codegnan.interfaces;

import com.codegnan.customExceptions.InSufficientBalanceException;
import com.codegnan.customExceptions.InSufficientMachineBalanceException;
import com.codegnan.customExceptions.InvalidAmountException;
import com.codegnan.customExceptions.NotAOperatorException;

public interface IATMService {
	
	
	//1.to get the user type whether the user is operator or normal user
	public abstract String getUserType() throws NotAOperatorException;
	
	//2.to withdraw Amount
	
	/*EXCEPTIONS WE GET :
	    1.will throw InValidAmountException if the amount is not a valid denomination
	    2.will throw InSufficientBalanceException if the customer has InSufficient in his/her account
	    3.will throw InSufficientMachineBalanceException if the machine has InSufficient cash
	   */
	public abstract double withdrawAmount(double wthAmount) throws InvalidAmountException,InSufficientBalanceException,InSufficientMachineBalanceException;
	
	//3. to deposit Amount
	public abstract void depositAmount(double dptAmount) throws InvalidAmountException;
	
	//4.to check Balance
	public abstract double checkAccountBalance();
	
	//5.to change PIN number
	public abstract void changePinNumber(int pinNumber);
	
	//6.to get the PIN number
	public abstract int getPinNumber();
	
	//7.to get User Name
	public  abstract String getUserName();
	
	//8.to decrease no.of chances while enter the wrong PIN Number
	public abstract void decreaseChances();

	//9.to get the Chances of PIN Number
	public abstract int getChances();
	
	//10.to reset the PIN Number Chances by the Bank Operator
	public abstract void resetPinChances();
	
	// 11.to get MINIStatement of the Account
	public abstract void generateMiniStatement();
	
	
}
