
package com.codeodyssey.fileparser.api.exception;


public class InvalidCSVFileException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public InvalidCSVFileException(String message) {
		 super(message);
	}
}
