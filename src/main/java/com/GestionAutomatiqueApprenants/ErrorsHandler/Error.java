package com.GestionAutomatiqueApprenants.ErrorsHandler;

import java.util.ArrayList;
import java.util.List;

import com.GestionAutomatiqueApprenants.exceptions.ErreurCodes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Error {
	private Integer httpCode;
	private ErreurCodes code;
	private String message;
	private List<String>errors = new ArrayList<String>();

}
