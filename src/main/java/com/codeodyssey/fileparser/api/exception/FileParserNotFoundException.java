
package com.codeodyssey.fileparser.api.exception;

/**
 * 
 * @Description File Parser Not found
 * exception thrown when Parser not configured for
 * file type
 */
public class FileParserNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
		
	public FileParserNotFoundException(String message) {
		 super(message);
	}
	
}


