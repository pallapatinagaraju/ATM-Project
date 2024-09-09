package com.codegnan.customExceptions;

public class InSufficientMachineBalanceException extends Exception{
	public InSufficientMachineBalanceException(String errorMsg) {
		super(errorMsg);
	}

}
