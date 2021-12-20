package com.GestionAutomatiqueApprenants.exceptions;

public enum ErreurCodes {
	APPRENANT_NOT_FOUND(1000),
	APPRENANT_INVALID(1001),
	APPRENANT_ALLREADY_EXISTE(1003);
	private int code ;

	private ErreurCodes(int code) {
	this.code = code;
	}

	public int getCode() {
		return code;
	}	
}
