package com.codeodyssey.fileparser.api.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.codeodyssey.fileparser.api.exception.InvalidCSVFileException;

/**
 * @author hiran
 * @Description This is the parent interface
 * used to provide Interchangeability & keep individual parsing algorithm
 * in the child class
 */

public interface IFileParserService {
	
	/*Returns the fileType parser supported by service*/
	String getFileType();
	
	/*Validate file before parsing*/
	boolean validate(File file) throws IOException,InvalidCSVFileException;
	
	/*Parse file as per file type*/
	List<? extends Object> parseFile(File file) throws IOException;
	
	/*Persists entity bean to database*/
	void save(List<? extends Object> entityBeanList);

}
