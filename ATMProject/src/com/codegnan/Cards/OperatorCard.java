package com.codegnan.Cards;

import com.codegnan.customExceptions.InSufficientBalanceException;
import com.codegnan.customExceptions.InSufficientMachineBalanceException;
import com.codegnan.customExceptions.InvalidAmountException;
import com.codegnan.customExceptions.NotAOperatorException;
import com.codegnan.interfaces.IATMService;

public class OperatorCard implements IATMService {
	
	private int pinNumber;
	private long id;
    private String name;
    private final String type = "operator";
    
   
	
	public OperatorCard(long idn,int pin, String name) {
		super();
		pinNumber = pin;
		id = idn;
		this.name = name;
	}
	

	@Override
	public String getUserType() throws NotAOperatorException {
		return type;
	}

	@Override
	public double withdrawAmount(double wthAmount)
			throws InvalidAmountException, InSufficientBalanceException, InSufficientMachineBalanceException {
		return 0;
	}

	@Override
	public void depositAmount(double dptAmount) throws InvalidAmountException {
		
		
	}

	@Override
	public double checkAccountBalance() {
		return 0;
	}

	@Override
	public void changePinNumber(int pinNumber) {	
		
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
		
	}

	@Override
	public int getChances() {
		return 0;
	}

	@Override
	public void resetPinChances() {
		
	}

	@Override
	public void generateMiniStatement() {
		
	}

}
