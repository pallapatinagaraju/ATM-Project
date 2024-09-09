    package com.codegnan.Cards;

	import java.util.ArrayList;
import java.util.Collections;

import com.codegnan.customExceptions.InSufficientBalanceException;
import com.codegnan.customExceptions.InSufficientMachineBalanceException;
import com.codegnan.customExceptions.InvalidAmountException;
import com.codegnan.customExceptions.NotAOperatorException;
import com.codegnan.interfaces.IATMService;

	

	public class HDFCDebitCard implements IATMService {
		String name;
		long debitCardNumber;
		double accountBalance;
		int pinNumber;
		ArrayList<String> statement;
		final String type = "user";
		int chances;
		
		
		
		public HDFCDebitCard( long debitCardNumber,String name , double accountBalance, int pinNumber) {
			//super();
			chances = 3;
			this.name = name;
		    //this.debitCardNumber = debitCardNumber;
			this.accountBalance = accountBalance;
			this.pinNumber = pinNumber;
			statement = new ArrayList<>();
		}
		
		
		
		@Override
		public String getUserType() throws NotAOperatorException {
			return type;
		}
		
		@Override
		public double withdrawAmount(double wthAmount)
				throws InvalidAmountException, InSufficientBalanceException, InSufficientMachineBalanceException {
			if(wthAmount <= 0) {
				throw new InvalidAmountException("You can Enter Zero(0) Amount to Withdraw please enter a valid Amount");
				} else if (wthAmount % 10 != 0) {
					throw new InSufficientBalanceException("Please Withdraw Multiples of 100(Hundred)" );
				}else if(wthAmount > accountBalance) {
						throw new InSufficientBalanceException("You dont have sufficient Funds to withdraw ... Please check your Balance ...");
					}else {
						accountBalance = accountBalance-wthAmount;
						statement.add("Debited : " + wthAmount);
						return wthAmount;
				}
		}
		
		@Override
		public void depositAmount(double dptAmount) throws InvalidAmountException {
			if (dptAmount <= 0 || dptAmount % 10 != 0) {
				throw new InvalidAmountException("Please deposit Multiples of 100(Hundred)");
			}else {
				accountBalance = accountBalance + dptAmount;
				statement.add("Credited : " + dptAmount);
			}
		}
		
		@Override
		public double checkAccountBalance() {
			return accountBalance;
		}
		
		@Override
		public void changePinNumber(int pinNumber) {
			this.pinNumber = pinNumber;
		}
		
		@Override
		public int getPinNumber() {
			return pinNumber;
		}
		
		@Override
		public String getUserName() {
			return name;
		}
		
		@Override
		public void decreaseChances() {
			--chances;
		}
		
		@Override
		public int getChances() {
			return chances;
		}
		
		@Override
		public void resetPinChances() {
			chances= 3;
		}
		
		@Override
		public void generateMiniStatement() {
			int count = 5;
			if(statement.size() == 0) {
				System.out.println("There are no Transactions happened");
				return;
			}
			System.out.println("================= Last 5 Transactions =================");
			Collections.reverse(statement);
			for(String tans : statement) {
				if(count == 0) {
					break;
				}
				System.out.println(tans);
				count--;
			}
			Collections.reverse(statement);
		}

		
	}

	

