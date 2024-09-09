package com.codegnan.customExceptions;

public class InSufficientBalanceException extends Exception{
	public  InSufficientBalanceException(String errorMsg){
			super(errorMsg);
	}
}
