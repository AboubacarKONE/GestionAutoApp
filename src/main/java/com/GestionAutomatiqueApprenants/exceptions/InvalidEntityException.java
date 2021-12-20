package com.GestionAutomatiqueApprenants.exceptions;

import java.util.List;

import lombok.Getter;

public class InvalidEntityException extends RuntimeException{
	@Getter
	private ErreurCodes errorCodes;
	@Getter
	private List<String>errors;
	public InvalidEntityException(String message) {
		super(message);
	}
	public InvalidEntityException(String message, Throwable cause) {
		super(message,cause);
	}
	public InvalidEntityException(String message,Throwable cause, ErreurCodes erreurCodes) {
		super(message,cause);
		this.errorCodes = erreurCodes;
	}
	public InvalidEntityException(String message,ErreurCodes erreurCodes) {
		super(message);
		this.errorCodes = erreurCodes;
	}
	public InvalidEntityException(String message,ErreurCodes erreurCodes, List<String>errors) {
		super(message);
		this.errorCodes=erreurCodes;
		this.errors =errors;
		
	}
}
